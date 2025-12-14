# CRUD Tasks

Uma API REST desenvolvida com **Spring Boot** para gerenciamento de tarefas, implementando operações CRUD (Create, Read, Update, Delete).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 4.0.0**
- **Spring Data JPA** - Persistência de dados
- **Spring Web MVC** - Criação de endpoints REST
- **PostgreSQL** - Banco de dados relacional
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências

## Estrutura do Projeto

```
CRUD_Tasks/
├── src/
│   ├── main/          # Código fonte principal
│   └── test/          # Testes automatizados
├── pom.xml            # Configuração do Maven
├── mvnw               # Maven Wrapper (Linux/Mac)
└── mvnw.cmd           # Maven Wrapper (Windows)
```

## Pré-requisitos

- **Java 17** ou superior instalado
- **PostgreSQL** configurado e rodando
- **Maven** (ou utilize o wrapper incluído)

## Configuração do Banco de Dados

Configure as credenciais do PostgreSQL no arquivo `application.properties` ou `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring. datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Sousxs/CRUD_Tasks.git
   cd CRUD_Tasks
   ```

2. **Execute a aplicação:**
   ```bash
   # Linux/Mac
   ./mvnw spring-boot:run

   # Windows
   mvnw. cmd spring-boot: run
   ```

3. A API estará disponível em: `http://localhost:8080`

## Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/tasks` | Lista todas as tarefas |
| `GET` | `/tasks/{id}` | Busca uma tarefa por ID |
| `POST` | `/tasks` | Cria uma nova tarefa |
| `PUT` | `/tasks/{id}` | Atualiza uma tarefa existente |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa |

## Testes

Execute os testes com: 

```bash
./mvnw test
```

## Licença

Este projeto está sob licença.  Consulte o arquivo LICENSE para mais detalhes. 

---
>  Feito por [Sousxs](https://github.com/Sousxs)
