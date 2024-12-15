Programação Orientada a Objetos

Este projeto foi desenvolvido como parte da disciplina de **Programação Orientada a Objetos**, com o propósito de integrar um banco de dados PostgreSQL ao back-end, utilizando o Spring Framework em Java, e de criar um front-end funcional que permita a interação com os dados de maneira eficiente.

## ✨ Funcionalidades Principais

- Integração com banco de dados **PostgreSQL**.
- Configuração do back-end utilizando **Java** e o **Spring Framework**.
- Desenvolvimento de um front-end interativo conectado ao back-end.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

Antes de iniciar, certifique-se de que os seguintes softwares estejam instalados no seu ambiente:

- **Java JDK 17** ou superior
- **Maven**
- **Node.js** ou **Yarn**
- **PostgreSQL**
- Extensão **Live Server** para o Visual Studio Code

### Passo a Passo

#### 1. Clone o Repositório

bash
# Clone o repositório para sua máquina local
git clone <URL_DO_REPOSITORIO>

# Navegue até o diretório do projeto
cd <PASTA_DO_REPOSITORIO>


#### 2. Configuração do Back-end

1. Acesse a pasta do back-end:

   
bash
   cd banco


2. Instale as dependências do Maven:

   
bash
   mvn install


3. Configure as credenciais do banco de dados no arquivo src/resources/application.properties:

   
properties
   spring.datasource.url=<URL_DO_BANCO>
   spring.datasource.username=<USUARIO_DO_BANCO>
   spring.datasource.password=<SENHA_DO_BANCO>


4. Ajuste as configurações de CORS no arquivo src/java/apresentacao/WebConfig.java, especificando a porta do front-end:

   
java
   allowedOrigin("http://localhost:<PORTA_DO_FRONTEND>");


#### 3. Configuração do Front-end

1. Navegue até a pasta do front-end:

   
bash
   cd front-end


2. Instale as dependências do projeto:

   
bash
   # Se utilizar Yarn
yarn install

   # Ou, se utilizar NPM
npm install


3. Inicie o front-end:

   - Abra o arquivo HTML principal utilizando a extensão **Live Server** no Visual Studio Code.

#### 4. Executando o Back-end

1. Localize e execute a classe principal AcessoADado.java, que está no seguinte caminho:

   
src/apresentacao/AcessoADado.java


---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **Frameworks:** Spring Framework, Maven
- **Banco de Dados:** PostgreSQL
- **Front-end:** HTML, CSS, JavaScript
- **Ferramentas Adicionais:** Node.js, Yarn/NPM, Live Server