<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/antonino3g/cadastro-pessoa">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/antonino3g/cadastro-pessoa">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/antonino3g/cadastro-pessoa">
  <a href="https://github.com/antonino3g">
    <img alt="Made by Antonino Praxedes" src="https://img.shields.io/badge/created%20by-Antonino%20Praxedes-blue">
  </a>
</p>

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

### 🧠 Filtro Dinâmico de Endereços
Funcionalidade extra que permite buscar em tempo real todos os endereços vinculados ao nome da pessoa.
![Image](https://github.com/user-attachments/assets/305136fd-a719-4808-8d61-1cd7b2a7ddd4)

## 🧩 Melhorias previstas para próximas versões

1. Substituir o preenchimento direto do formulário por um **dialog ao editar Pessoa**, melhorando a usabilidade e mantendo a interface mais limpa.
2. Corrigir o comportamento da **edição de endereços**: atualmente, ao abrir o dialog pela primeira vez, os dados não são carregados corretamente. O problema só se resolve após alguma interação adicional com a tela, possivelmente devido ao ciclo de vida do JSF combinado com bindings ou cache da árvore de componentes.
3. Estilar as páginas & fontes.


### :recycle: Como contribuir

- Fork esse repositório;
- Crie uma branch com a sua feature: `git checkout -b my-feature`
- Commit suas mudanças: `git commit -m 'feat: My new feature'`
- Push a sua branch: `git push origin my-feature`


## :memo:  License

MIT License - Veja [LICENSE](https://opensource.org/licenses/MIT) para mais detalhes.


