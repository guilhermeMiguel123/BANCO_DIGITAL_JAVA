package apresentacao;

import java.util.*;
import java.sql.*;

import org.springframework.stereotype.Component;

@Component
public class AcessoADado {
  public AcessoADado() {
    // Construtor vazio para inicialização
  }

  /** 
   * Conecta ao banco de dados PostgreSQL.
   * 
   * @return um objeto Connection
   * @throws SQLException se ocorrer algum erro de conexão
  */

  public Connection connect() throws SQLException {
    String url = "jdbc:postgresql://localhost/banco";
    Properties props = new Properties();
    props.setProperty("user", "postgres");
    props.setProperty("password", "tone123TONE");
    props.setProperty("ssl", "false");

    return DriverManager.getConnection(url, props);
  }

  /**
   * Cadastra uma nova conta no banco de dados.
   * 
   * @param numero número de conta
   * @param saldo saldo inicial da conta
   * @return mensagem de sucesso ou erro
   */
  
   public String cadastrarConta(String numero, float saldo) {
    String SQL = "INSERT INTO public.conta(numero, saldo) values (?, ?)";
    String mensagem;

    try(Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL)) {
          pstmt.setString(1, numero); // Corrigido: tipo String para o número
          pstmt.setFloat(2, saldo); // Corrigido: tipo Float para o saldo

          int affectedRows = pstmt.executeUpdate();
          if(affectedRows > 0) {
            mensagem = "Cadastro de conta " + numero + " realizado com sucesso.";
          } else {
            mensagem = "Erro ao cadastrar conta.";
          }
    } catch(SQLException ex) {
      mensagem = "Erro de SQL: " + ex.getMessage();
    }

    return mensagem;
   }

   /**
     * Altera o saldo de uma conta.
     *
     * @param numero número da conta
     * @param saldo  novo saldo
     * @return mensagem de sucesso ou erro
    */

    public String alterarConta(String numero, float saldo) {
      String SQL = "UPDATE public.conta SET saldo = ? WHERE numero = ?";
      String mensagem;

      try (Connection conn = connect();
          PreparedStatement pstmt = conn.prepareStatement(SQL)) {

          pstmt.setFloat(1, saldo);  // Corrigido: tipo Float para o saldo
          pstmt.setString(2, numero);

          int affectedRows = pstmt.executeUpdate();
          if (affectedRows > 0) {
              mensagem = "Saldo da conta " + numero + " alterado com sucesso.";
          } else {
              mensagem = "Conta não encontrada.";
          }
      } catch (SQLException ex) {
          mensagem = "Erro de SQL: " + ex.getMessage();
      }

      return mensagem;
    }

   /**
    * Lista todas as contas de banco de dados.
    */
    public List<Map<String, Object>> listarContas() {
      String SQL = "SELECT numero, saldo FROM public.conta";
      List<Map<String, Object>> contas = new ArrayList<>();

      try(Connection conn = connect();
          PreparedStatement pstmt = conn.prepareStatement(SQL);
          ResultSet rs = pstmt.executeQuery()) {
            while(rs.next()) {
              Map<String, Object> conta = new HashMap<>();
              conta.put("numero", rs.getString("numero"));
              conta.put("saldo", rs.getFloat("saldo"));
              contas.add(conta);
            }
      } catch(SQLException ex) {
        System.out.println("Erro de SQL: " + ex.getMessage());
      }

      return contas;
    }

    /**
     * Exclui uma conta do banco de dados.
     * 
     * @param numero número da conta
     * @return mensagem de sucesso ou erro
     */

    public String excluirConta(String numero) {
      String SQL = "DELETE FROM public.conta WHERE numero = ?";
      String mensagem;

      try(Connection conn = connect();
        PreparedStatement pstmt = conn.prepareStatement(SQL)) {
          pstmt.setString(1, numero);

          int affectedRows = pstmt.executeUpdate();
          if(affectedRows > 0) {
            mensagem = "Conta " + numero + " excluída com sucesso.";
          } else {
            mensagem = "Conta não encontrada.";
          }
      } catch(SQLException ex) {
        mensagem = "Erro de SQL: " + ex.getMessage();
      }

      return mensagem;
    }
}