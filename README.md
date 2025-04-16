# Desafio Técnico – Cadastro de Pessoas

Projeto simples de CRUD (Create, Read, Update, Delete) desenvolvido **sem frameworks**, simulando cenários comuns em sistemas legados — como os encontrados em órgãos públicos.

## 🛠️ Stack Utilizada

- Java EE 8  
- Tomcat 9  
- JDK 11+  
- PostgreSQL 17  
- pgAdmin 4
- Maven
- Docker Compose 28.0.4+  

O projeto está totalmente conteinerizado para facilitar a execução.

---

## 🚀 Como Rodar o Projeto

1. Clone ou descompacte o repositório (a Bruna possui o link).
2. Acesse a pasta raiz do projeto.
3. Abra dois terminais:

**Terminal 1 – Build com Maven:**

```bash
mvn clean package -Pdev
```
Terminal 2 – Subir os containers com Docker:
```bash
docker compose down
docker compose up --build
```

Acesse o sistema pelo navegador:
📍 http://localhost:8080/


