# Ford Challenge 2026 — FordCare Intelligence

## Integrantes

| Nome | RM |
|---|---|
| Luan Orlandelli Ramos | RM 554747 |
| Arthur Bobadilla Franchi | RM 555056 |
| Jorge Luiz Silva Santos | RM 554418 |

---

# 1. Objetivos do Projeto

O projeto **FordCare Intelligence** foi desenvolvido como solução tecnológica para o desafio proposto pela Ford em parceria com a FIAP, tendo como principal objetivo aumentar o indicador de retenção de clientes no pós-venda, conhecido como **VIN Share**.

A solução busca auxiliar concessionárias e equipes estratégicas da Ford a:

- Identificar clientes com risco de evasão;
- Melhorar a fidelização no pós-venda;
- Gerenciar leads de forma inteligente;
- Gerar recomendações automatizadas;
- Monitorar indicadores estratégicos;
- Centralizar informações em uma arquitetura segura e escalável.

---

# 2. Descrição Oficial do Desafio

## Desafio 02 — Impulsionando o VIN Share na América do Sul com Soluções Inteligentes

### Contexto

Reter clientes no serviço de pós-venda é crucial para o sucesso e a sustentabilidade do negócio. O indicador-chave é o VIN Share, que representa a porcentagem de veículos Ford que utilizam a rede oficial para manutenções.

### Objetivo

Criar uma solução tecnológica que contribua para a retenção e fidelização de clientes no pós-venda, aumentando o VIN Share na América do Sul.

---

# 3. Problemas de Negócio Identificados

Durante a análise do desafio, foram identificados os seguintes problemas:

- Falta de previsibilidade sobre clientes com risco de evasão;
- Dificuldade de monitoramento estratégico dos leads;
- Baixa integração entre análise de clientes e tomada de decisão;
- Ausência de inteligência automatizada para retenção;
- Necessidade de uma arquitetura segura e escalável para integração entre sistemas.

---

# 4. Explicação da Solução

O projeto **FordCare Intelligence** consiste em uma plataforma baseada em APIs RESTful desenvolvida em Spring Boot, integrada a banco de dados PostgreSQL e preparada para integração com aplicações mobile e dashboards inteligentes.

A solução realiza:

- Gerenciamento de clientes;
- Gerenciamento de leads;
- Controle de status de conversão;
- Dashboard estratégico;
- Classificação inteligente de clientes;
- Recomendação automática baseada em risco;
- Monitoramento e auditoria;
- Segurança avançada da API.

---

# 5. Cenário de Uso Real

### Exemplo

Um cliente Ford deixa de realizar revisões periódicas na concessionária oficial.

O sistema:

1. Analisa o histórico do cliente;
2. Identifica risco de evasão;
3. Classifica o cliente com IA;
4. Gera recomendação automática;
5. Cria leads de retenção;
6. Permite acompanhamento pelos analistas.

Com isso, a concessionária pode agir preventivamente para aumentar o VIN Share.

---

# 6. Arquitetura da Solução

```text
[Mobile App / Cliente REST]
                |
                | HTTP + JSON + JWT
                v
        [Spring Boot API]
                |
    -------------------------
    |           |           |
    v           v           v
Controllers  Services  Security
                |
                v
         Repositories
                |
                v
        PostgreSQL Database
                |
                v
             Flyway
```

---

# 7. Fluxo da Aplicação

```text
Usuário → Login JWT
        → Dashboard
        → Consulta Clientes
        → Classificação IA
        → Geração de Leads
        → Atualização de Status
        → Auditoria e Logs
```

---

# 8. Tecnologias Utilizadas

## Backend

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Maven

## Banco de Dados

- PostgreSQL
- Flyway

## Segurança

- JWT
- BCrypt
- RBAC
- Rate Limiting (Bucket4j)
- Auditoria
- CORS

## Documentação

- Swagger / OpenAPI

## Cliente Consumidor

- React Native + Expo (camada mobile consumidora da API REST)

---

# 9. Justificativa das Tecnologias

| Tecnologia | Motivo |
|---|---|
| Spring Boot | Facilidade na criação de APIs REST seguras e escaláveis |
| PostgreSQL | Banco relacional robusto e confiável |
| Flyway | Controle seguro de migrações |
| JWT | Autenticação stateless |
| BCrypt | Criptografia de senhas |
| Swagger | Documentação automática da API |
| Bucket4j | Proteção contra abuso e flood |
| React Native | Cliente mobile multiplataforma |

---

# 10. Estrutura do Backend

```text
src/main/java/fordcare_api
│
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
```

---

# 11. Estrutura das Pastas

## controller

Responsável pelos endpoints REST da aplicação.

## service

Camada de regras de negócio.

## repository

Comunicação com banco de dados via JPA.

## entity

Entidades mapeadas para o PostgreSQL.

## dto

Objetos de transferência de dados.

## security

JWT, autenticação, autorização e filtros de segurança.

## config

Configurações da aplicação, OpenAPI e CORS.

## exception

Tratamento global de exceções.

---

# 12. Banco de Dados

O projeto utiliza PostgreSQL como banco de dados principal.

## Principais tabelas

- users
- roles
- customers
- leads
- predictions
- recommendations
- audit_logs

---

# 13. Flyway e Controle de Migrações

O controle de versões do banco é realizado com Flyway.

## Migrations utilizadas

```text
V1__create_initial_tables.sql
V2__insert_initial_data.sql
V3__create_audit_logs_table.sql
```

Benefícios:

- Versionamento seguro;
- Reprodutibilidade;
- Padronização do ambiente;
- Controle de evolução do banco.

---

# 14. APIs REST e Endpoints

## Autenticação

```http
POST /auth/login
```

## Clientes

```http
GET /customers
GET /customers/{id}
```

## Dashboard

```http
GET /insights/dashboard
```

## Leads

```http
GET /leads
POST /leads
PUT /leads/{id}/status
```

## Recomendações

```http
GET /recommendations/{customerId}
```

## IA e Predições

```http
POST /predictions/classify
```

---

# 15. Swagger / OpenAPI

A documentação da API foi implementada utilizando Swagger/OpenAPI.

## Acesso

```text
http://localhost:8080/swagger-ui.html
```

O Swagger funciona como contrato dos endpoints REST e permite:

- Visualização das rotas;
- Teste dos endpoints;
- Integração via Bearer Token JWT;
- Documentação automática dos DTOs.

---

# 16. Segurança da Aplicação

## JWT

Autenticação baseada em token JWT.

## BCrypt

Criptografia segura de senhas.

## RBAC

Controle de acesso baseado em perfis:

- ADMIN
- ANALYST
- DEALER_MANAGER

## CORS

Configuração segura de acesso entre aplicações.

## Rate Limiting

Proteção contra flood e abuso de requisições utilizando Bucket4j.

## Tratamento Seguro de Erros

A aplicação possui tratamento global de exceções sem exposição de stack trace.

---

# 17. Auditoria e Logs

O sistema implementa auditoria persistida em banco de dados.

## Eventos auditados

- LOGIN_SUCCESS
- LEAD_CREATED
- LEAD_STATUS_UPDATED
- CUSTOMER_CLASSIFIED_BY_AI

## Informações registradas

- ação;
- endpoint;
- IP;
- usuário;
- timestamp.

---

# 18. IA e Predições

O projeto possui um módulo de classificação inteligente de clientes.

A funcionalidade realiza:

- análise de risco;
- classificação de clientes;
- geração de recomendações automáticas;
- suporte à retenção pós-venda.

O código da IA encontra-se desacoplado da camada mobile, mantendo a separação arquitetural da solução.

---

# 19. Mobile como Cliente Consumidor da API

A solução possui integração com aplicação mobile desenvolvida em React Native + Expo.

O mobile atua como:

```text
Cliente consumidor da API REST
```

Consumindo endpoints protegidos por JWT.

---

# 20. Cumprimento dos Requisitos

## SOA

✔ APIs RESTful  
✔ Organização modular  
✔ Separação de camadas  
✔ Swagger/OpenAPI  
✔ Banco PostgreSQL  
✔ Flyway  
✔ Integração por serviços  

---

# 21. Diferenciais Além dos Requisitos

O projeto possui funcionalidades e estruturas que ultrapassam os requisitos mínimos solicitados:

- Dashboard estratégico;
- Sistema de auditoria persistida;
- Rate limiting;
- Controle de acesso RBAC;
- Logs de segurança;
- IA para classificação de clientes;
- Arquitetura preparada para expansão;
- Integração completa entre backend, segurança e análise de dados.

---

# 22. Como Rodar o Projeto

## Pré-requisitos

Antes de iniciar o projeto, é necessário possuir instalado na máquina:

- Java 21
- Maven
- PostgreSQL
- IntelliJ IDEA (recomendado)
- Postman (para testes da API)

---

## 1. Clonar o Repositório

```bash
git clone https://github.com/LuanOrlandelli/CheckPoint3-SOA
```

Entrar na pasta do projeto:

```bash
cd fordcare-api
```

---

## 2. Configurar o PostgreSQL

Abrir o PostgreSQL/pgAdmin e criar o banco de dados:

```sql
CREATE DATABASE fordcare;
```

---

## 3. Configurar o application.properties

Abrir o arquivo:

```text
src/main/resources/application.properties
```

Configurar as credenciais do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/fordcare
spring.datasource.username=postgres
spring.datasource.password=SUASENHA

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.flyway.enabled=true
```

Substituir:

```text
SUASENHA
```

pela senha configurada no PostgreSQL da máquina local.

---

## 4. Instalar as Dependências Maven

No terminal do projeto, executar:

```bash
mvn clean install
```

Esse comando irá:

- baixar dependências;
- compilar o projeto;
- preparar a aplicação para execução.

---

## 5. Executar o Projeto

O projeto pode ser iniciado de duas formas.

### Opção 1 — IntelliJ IDEA

Executar a classe principal:

```text
FordcareApiApplication.java
```

Localização:

```text
src/main/java/.../FordcareApiApplication.java
```

---

### Opção 2 — Terminal

Executar:

```bash
mvn spring-boot:run
```

---

## 6. Flyway e Criação Automática das Tabelas

Ao iniciar o projeto:

- o Flyway executará automaticamente as migrations;
- as tabelas serão criadas no PostgreSQL;
- os dados iniciais serão inseridos automaticamente.

Migrations utilizadas:

```text
V1__create_initial_tables.sql
V2__insert_initial_data.sql
V3__create_audit_logs_table.sql
```

---

## 7. Acessar o Swagger

Após iniciar o backend, acessar:

```text
http://localhost:8080/swagger-ui.html
```

No Swagger é possível:

- visualizar endpoints;
- testar a API;
- autenticar com JWT;
- validar requests e responses.

---

## 8. Realizar Login

Endpoint:

```http
POST /auth/login
```

Exemplo de body:

```json
{
  "email": "admin@fordcare.com",
  "password": "123456"
}
```

A resposta retornará um token JWT.

---

## 9. Utilizar JWT no Swagger

1. Copiar o token retornado no login;
2. Clicar em:

```text
Authorize
```

no Swagger;

3. Inserir:

```text
Bearer SEU_TOKEN
```

4. Confirmar autenticação.

Agora os endpoints protegidos poderão ser utilizados.

---

## 10. Testar os Endpoints

Exemplos:

### Clientes

```http
GET /customers
```

### Dashboard

```http
GET /insights/dashboard
```

### Leads

```http
POST /leads
```

### IA e Predições

```http
POST /predictions/classify
```

---

## 11. Auditoria e Logs

O sistema registra automaticamente:

- login;
- criação de leads;
- alteração de status;
- classificação IA.

Os registros são armazenados na tabela:

```text
audit_logs
```

Consulta exemplo:

```sql
SELECT * FROM audit_logs;
```

---

### Swagger

```text
http://localhost:8080/swagger-ui.html
```

---

# 23. Conclusão

O projeto FordCare Intelligence foi desenvolvido com foco em arquitetura orientada a serviços, segurança, escalabilidade e integração entre sistemas.

A solução atende aos requisitos propostos pela Ford e pelas disciplinas envolvidas, entregando uma arquitetura moderna baseada em APIs RESTful, autenticação JWT, banco de dados versionado e recursos avançados de monitoramento e auditoria.

Além dos requisitos mínimos, o projeto também apresenta diferenciais técnicos como inteligência artificial, rate limiting, RBAC e auditoria persistida, aproximando a solução de um cenário corporativo real.
