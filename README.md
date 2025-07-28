# spring-boot-oracle-auth

Projeto básico com Spring Boot, Spring Data JPA, Spring Security e Oracle PL/SQL.

## Tecnologias

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- Oracle Database
- PL/SQL (procedure de cadastro de usuário)

## Estrutura

- `/oracle/CREATE_USER_PROC.sql` – procedure para cadastro
- Código Java em `src/main/java/com/example/auth/...`
- Configuração em `src/main/resources/application.properties`

## Endpoints

- `POST /register`: registra usuário via procedure
- `POST /login`: autenticador básico
- `GET /admin`: apenas usuários com role `ADMIN`

## Como usar

1. Execute a procedure no Oracle:
   ```bash
   sqlplus seu_usuario/sua_senha@XE @oracle/CREATE_USER_PROC.sql
   ```
