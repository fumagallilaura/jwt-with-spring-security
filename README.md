# User Authentication API

Esta é uma API RESTful desenvolvida em Java para registro e login de usuários. A API permite que novos usuários se registrem e que usuários existentes façam login.

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Security
- JPA/Hibernate
- MySQL (ou qualquer outro banco de dados relacional)
- Maven

## Requisitos

- JDK 11 ou superior
- Maven 3.6+
- Banco de dados MySQL (ou outro banco de dados configurado)

## Instalação

1. Clone o repositório:

   ```bash
   git clone git@github.com:fumagallilaura/jwt-with-spring-security.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd jwt-with-spring-security
   ```
3. Configure o banco de dados no arquivo `application.yml`:
   ```yaml
   spring:
    application:
        name: jwt-with-spring-security
    datasource:
        url: jdbc:postgresql://motty.db.elephantsql.com:5432/USER_DB
        username: USER_NAME
        password: USER_PASSWORD
        driver-class-name: org.postgresql.Driver
    jpa:
        hibernate:
        ddl-auto: update
        dialect: org.hibernate.dialect.PostgreSQLDialect
        show-sql: true
    ```
4. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints da API

1. Registro de Usuário

URL: /auth/register

Método: POST

Descrição: Registra um novo usuário no sistema.

Corpo da requisição:
```json
{
  "username": "exemplo",
  "email": "exemplo@email.com",
  "password": "senha123"
}
```

Resposta de Sucesso(201 Created):
```json
{
    "mensagem": "Usuário registrado com sucesso!"
}
```

Erros:

400 Bad Request: Se o e-mail ou nome de usuário já estiverem em uso.

2. Login de Usuário

URL: /auth/login

Método: POST

Descrição: Autentica um usuário e retorna um token JWT.

Corpo da Requisição:

```json
{
  "username": "exemplo",
  "password": "senha123"
}
```

Resposta de Sucesso (200 OK):

```json
{
  "token": "jwt-token-gerado"
}
```

Erros:

401 Unauthorized: Se as credenciais estiverem incorretas.

3. Acesso a Dados do Usuário (Protegido)

URL: /api/user/me

Método: GET

Descrição: Retorna os dados do usuário autenticado.

Cabeçalho de Autorização:

```
Authorization: Bearer <jwt-token>
```

Resposta de Sucesso (200 OK):

```json
{
  "id": 1,
  "username": "exemplo",
  "email": "exemplo@email.com"
}
```

Erros:

401 Unauthorized: Se o token JWT não for fornecido ou for inválido.

## Segurança
A API utiliza JWT (JSON Web Token) para autenticação. Após o login, o cliente deve incluir o token JWT no cabeçalho de todas as requisições subsequentes para acessar endpoints protegidos.

Exemplo de cabeçalho de autorização:

```
Authorization: Bearer <jwt-token>
```

Estrutura de Diretórios

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── exemplo/
│   │           └── userauth/
│   │               ├── controller/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── security/
│   │               └── service/
│   └── resources/
│       ├── application.properties
│       └── schema.sql
└── test/
    └── java/
        └── com/
            └── exemplo/
                └── userauth/
```

## Testes
Para rodar os testes unitários, execute o seguinte comando:

```bash
mvn test
```