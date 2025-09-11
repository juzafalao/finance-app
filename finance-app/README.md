# Finance App

Aplicação de controle financeiro familiar.

## Como rodar (resumo)
1. Requisitos: Java 21, Maven, Docker/Colima.
2. Banco: `docker compose up -d`
3. App (quando a base estiver pronta): `cd finance-app && mvn spring-boot:run`
4. Acesse: `http://localhost:8080` – Swagger: `/swagger-ui/index.html`

## Padrões
- Java 21 + Spring Boot
- Postgres + Flyway
- CI com GitHub Actions
- Sem arquivos binários no Git (.zip, .DS_Store etc.)
