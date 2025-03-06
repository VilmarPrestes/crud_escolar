# Sistema de Gestão Escolar

**Sistema de Gestão Escolar** é uma API RESTful desenvolvida com **Spring Boot** que permite o gerenciamento de **Cursos** e **Alunos**. A aplicação oferece funcionalidades de **CRUD** (Criar, Ler, Atualizar, Deletar) para cursos e alunos, com validações de dados como CPF, datas e status. O sistema permite que alunos sejam vinculados a cursos já existentes e evita a exclusão de cursos que possuam alunos cadastrados.

## Funcionalidades

### Cursos
- Cadastro de novos cursos.
- Alteração de dados de curso já cadastrado.
- Exclusão de cursos.
- Listagem de cursos.

### Alunos
- Cadastro de novos alunos, vinculando-os a um curso já existente.
- Alteração de dados de aluno já cadastrado.
- Exclusão de alunos.
- Listagem de alunos.

## Tecnologias Utilizadas
- **Backend**: Spring Boot
- **Banco de Dados**: H2 (em memória)
- **Validações**: Bean Validation (javax.validation)
- **Documentação da API**: Swagger (Springfox)

## Documentação da API (Swagger)
A documentação da API é gerada automaticamente e pode ser acessada de forma interativa através do **Swagger**. Para acessar a interface do Swagger, basta rodar o projeto e acessar o seguinte endereço: http://localhost:8080/swagger-ui/


## Endpoints

### **Cursos**
- **GET /cursos**: Listar todos os cursos.
- **POST /cursos**: Criar um novo curso.
- **PUT /cursos/{id}**: Atualizar um curso existente.
- **DELETE /cursos/{id}**: Excluir um curso.

### **Alunos**
- **GET /alunos**: Listar todos os alunos.
- **POST /alunos**: Criar um novo aluno.
- **PUT /alunos/{id}**: Atualizar um aluno existente.
- **DELETE /alunos/{id}**: Excluir um aluno.

## Como Rodar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/sistema-gestao-escolar.git



## Estrutura do Projeto

src/ ├── main/ │ ├── java/ │ │ └── com/ │ │ └── vilmarprestes/ │ │ └── crud_escolar/ │ │ ├── config/ # Configurações do projeto (Swagger, configuração de banco de dados, etc.) │ │ ├── controller/ # Controladores responsáveis pelos endpoints (Alunos, Cursos) │ │ ├── dto/ # Data Transfer Objects (AlunosDTO, CursosDTO) │ │ ├── model/ # Modelos das entidades (Aluno, Curso) │ │ ├── repository/ # Interfaces de repositórios para persistência (AlunoRepository, CursoRepository) │ │ └── service/ # Lógica de negócio (AlunoService, CursoService) │ └── resources/ │ ├── application.properties # Configurações da aplicação (porta, banco de dados, etc.) │ └── static/ # Arquivos estáticos (não utilizados neste projeto) └── pom.xml # Gerenciador de dependências (Maven)

