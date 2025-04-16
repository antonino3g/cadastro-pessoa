# 🚀 Desafio Técnico – Cadastro de Pessoas

Projeto simples de CRUD (**Create, Read, Update, Delete**) desenvolvido **sem frameworks**, com foco em simular cenários típicos de sistemas legados — comuns em órgãos públicos.

---

## ⚙️ Stack Utilizada

- Java EE 8  
- Apache Tomcat 9  
- JDK 11+  
- PostgreSQL 17  
- pgAdmin 4  
- Maven  
- Docker Compose 28.0.4+

> ✅ O projeto está **100% conteinerizado** para facilitar a execução.

---

## 📦 Requisitos

- Java 11 ou superior  
- Docker + Docker Compose instalados

---

## 🧪 Como Executar o Projeto

1. Clone este repositório ou [baixe o ZIP aqui](https://drive.google.com/drive/folders/1LXKPlTMoPs_Rsll0s3opP7fFyrOVvwh8?usp=sharing)
2. Acesse a pasta raiz do projeto
3. Abra **dois terminais**:

### 🧱 Terminal 1 – Build com Maven

```bash
mvn clean package -Pdev
```

### 🐳 Terminal 2 – Subir containers com Docker

Terminal 2 – Subir os containers com Docker:
```bash
cd docker
docker compose down
docker compose up --build
```
![Image](https://github.com/user-attachments/assets/8b83c86c-b368-476d-b37d-eb7fc5f153e5)

### 💻 Acesse o sistema no browser 
📍 http://localhost:8080/


