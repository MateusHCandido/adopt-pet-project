## 💻 Sobre o projeto

Adopet é um site fictício de adoção de pets, com funcionalidades para cadastro de tutores, de abrigos e de pets, além de solicitação de adoções. Nesse repositório o projeto será uma API Rest em Java do Adopet.

---

## 📝 Observações do autor

A utilização de banco foi migrada para o PostgreSQL, então o pom.xml e as configurações do ambiente de desenvolvimento estão baseadas no PostgreSQL.
 Dentro do diretório resources>db.migration, os arquivos .sql que geram as tabelas foram refatoradas para a sintaxe do PostgreSQL.

Não foi apresentado no curso, mas quis aplicar o conhecimento do Swagger, uma ferramente utilizada para documentar os 
endpoints das APIs geradas. Assim que o servidor estiver rodando, acessar o [Swagger](http://localhost:8080/swagger-ui/index.html)

---

## ⚙️ Funcionalidades

- [x] Cadastro/atualização de tutores;
- [x] Cadastro de abrigos;
- [x] Cadastro de pets do abrigo;
- [x] Listagem de pets disponíveis para adoção;
- [x] Solicitação de adoção;
- [x] Aprovação/reprovação de adoção;

---

## 🎨 Layout

O projeto desse repositório é apenas a API Backend, mas existe um figma com o layout que está disponível neste link: <a href="https://www.figma.com/file/TlfkDoIu8uyjZNla1T8TpH?embed_host=notion&kind=&node-id=518%3A11&t=esSUkfGQEWUeUASj-1&type=design&viewer=1">Layout no Figma</a>

---

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Maven](https://maven.apache.org)**
- **[MySQL](https://www.mysql.com)**
- **[Hibernate](https://hibernate.org)**
- **[Flyway](https://flywaydb.org)**

---

## 📝 Licença

O projeto desse repositório foi desenvolvido por [Alura](https://www.alura.com.br) e utilizado nos cursos de boas práticas de programação com Java.

Instrutor: [Rodrigo Ferreira](https://cursos.alura.com.br/user/rodrigo-ferreira)


