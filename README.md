📚 Projeto Faculdade - Programação Orientada a Objetos
Este projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos, com o objetivo de integrar um banco de dados PostgreSQL ao back-end e criar um front-end funcional para interação com os dados.
✨ Funcionalidades
•	Integração com o banco de dados PostgreSQL.
•	Configuração de back-end com Java e Spring Framework.
•	Desenvolvimento de um front-end funcional conectado ao back-end.
________________________________________
🚀 Como Executar o Projeto
Pré-requisitos
Antes de começar, certifique-se de ter as ferramentas abaixo instaladas:
•	Java JDK 17+
•	Maven
•	Node.js e/ou Yarn
•	PostgreSQL
•	Extensão Live Server para o VSCode.
Passo a passo
1️⃣ Clone o Repositório
bash
Copiar código
git clone <URL_DO_REPOSITÓRIO>  
cd <PASTA_DO_REPOSITÓRIO>  
2️⃣ Configuração do Back-end
1.	Acesse a pasta do back-end:
bash
Copiar código
cd banco  
2.	Instale as dependências do Maven:
bash
Copiar código
mvn install  
3.	Atualize as configurações do banco de dados:
No arquivo src/resources/application.properties, insira as credenciais do PostgreSQL:
properties
Copiar código
spring.datasource.url=<URL_DO_BANCO>  
spring.datasource.username=<USUÁRIO_DO_BANCO>  
spring.datasource.password=<SENHA_DO_BANCO>  
4.	Configure o CORS:
No arquivo src/java/apresentacao/WebConfig.java, ajuste a porta do front-end:
java
Copiar código
allowedOrigin("http://localhost:<PORTA_DO_FRONT-END>");
3️⃣ Configuração do Front-end
1.	Acesse a pasta do front-end:
bash
Copiar código
cd front-end  
2.	Instale as dependências:
bash
Copiar código
yarn install  
ou
bash
Copiar código
npm install  
3.	Inicie o front-end:
Abra o arquivo HTML principal com a extensão Live Server.
4️⃣ Executando o Back-end
1.	No back-end, execute a classe principal AcessoADado.java, localizada em:
bash
Copiar código
src/apresentacao/AcessoADado.java  
________________________________________
🛠️ Tecnologias Utilizadas
•	Linguagem: Java
•	Frameworks: Spring Framework, Maven
•	Banco de Dados: PostgreSQL
•	Front-end: HTML, CSS, JavaScript
•	Ferramentas: Node.js, Yarn/NPM, Live Server
________________________________________
📝 Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
________________________________________
📄 Licença
Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais informações.


 



