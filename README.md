# Minha Lista de Animes

Sistema web para cadastro e gerenciamento de animes, desenvolvido com **Java + Spring Boot** no Back-end e **HTML, CSS e JavaScript Vanilla** no Front-end.

O sistema permite cadastrar animes com:

- Título
- Quantidade de episódios
- Data de conclusão
- Nota
- Status
- Gênero

O Back-end disponibiliza uma **API REST** e utiliza o **H2 Database** para armazenamento dos dados.

---

## Tecnologias utilizadas

### Back-end
- Java
- Spring Boot
- Spring Web
- Spring JDBC
- H2 Database
- Maven

### Front-end
- HTML5
- CSS3
- JavaScript Vanilla
- Fetch API

### Comunicação
- API REST
- JSON
- CORS

---

## Estrutura do projeto

```text
projeto/
│
├── Backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/projeto/individual/
│   │       │       ├── Anime.java
│   │       │       └── AnimeController.java
│   │       │
│   │       └── resources/
│   │           └── application.properties
│   │
│   └── pom.xml
│
└── FrontEnd/
    ├── index.html
    └── style.css
```

O JavaScript está diretamente no arquivo `index.html`.

---

## Como executar

### Pré-requisitos

- Java JDK
- Maven
- VS Code ou outra IDE
- Navegador
- Live Server

Verifique as instalações:

```bash
java -version
mvn -version
```

### Back-end

Entre na pasta:

```bash
cd Backend
```

Execute:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

### Front-end

Abra o `index.html` utilizando o **Live Server**.

Normalmente estará disponível em:

```text
http://127.0.0.1:5500
```

---

## Banco de dados

O projeto utiliza o **H2 Database em memória**.

Configuração:

```properties
spring.datasource.url=jdbc:h2:mem:animebd
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.sql.init.mode=always
```

O banco é reiniciado junto com a aplicação.

### H2 Console

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:animebd
```

Usuário:

```text
sa
```

---

## Endpoints

### Listar animes

```http
GET /animes
```

### Cadastrar anime

```http
POST /animes
```

Exemplo:

```json
{
    "titulo": "Naruto",
    "episodios": 220,
    "dataConclusao": "2026-09-02",
    "nota": 9,
    "status": "Finalizado",
    "genero": "Ação"
}
```

### Listar gêneros

```http
GET /animes/generos
```

---

## Funcionalidades

- Cadastro de animes;
- Listagem dos animes cadastrados;
- Filtro por gênero;
- Seleção dinâmica dos gêneros através da API;
- Validação dos dados no Front-end e Back-end;
- Impedimento de títulos duplicados.

---

## Validações

- Título obrigatório;
- Episódios maiores que zero;
- Nota entre 0 e 10;
- Status obrigatório;
- Gênero obrigatório;
- Data de conclusão não pode ser futura;
- Títulos duplicados não são permitidos.

---

## Status

- `Finalizado`
- `Assistindo`
- `Pausado`

## Gêneros

- `Ação`
- `Aventura`
- `Comédia`
- `Drama`
- `Fantasia`

---

## Fluxo do sistema

```text
Front-end
   │
   │ Fetch / JSON
   ▼
Spring Boot
   │
   │ JdbcTemplate
   ▼
H2 Database
```

---

## Códigos de resposta

| Código | Descrição |
|---|---|
| 200 | Requisição realizada com sucesso |
| 201 | Anime cadastrado com sucesso |
| 400 | Dados inválidos |
| 409 | Anime com o mesmo título já cadastrado |

---

## Licença

Projeto desenvolvido para fins acadêmicos na SPTech.
