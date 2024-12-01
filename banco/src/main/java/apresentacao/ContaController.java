package apresentacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final AcessoADado acessoADado;

    @Autowired
    public ContaController(AcessoADado acessoADado) {
        this.acessoADado = acessoADado;
    }

    @PostMapping
    public String cadastrarConta(@RequestParam String numero, @RequestParam float saldo) {
        return acessoADado.cadastrarConta(numero, saldo);
    }

    @PutMapping
    public String alterarConta(@RequestParam String numero, @RequestParam float saldo) {
        return acessoADado.alterarConta(numero, saldo);
    }

    @GetMapping
    public List<Map<String, Object>> listarContas() {
        return acessoADado.listarContas();
    }

    @DeleteMapping
    public String excluirConta(@RequestParam String numero) {
        return acessoADado.excluirConta(numero);
    }
}
