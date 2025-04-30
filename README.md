# Projeto: Sistema de Cadastro

Este projeto é um sistema simples de cadastro desenvolvido em **Java** utilizando **JDBC** para conexão com um banco de dados PostgreSQL. Ele permite realizar operações básicas de CRUD (Create, Read, Update, Delete) em uma tabela chamada `tab_cadastro`.

## Estrutura do Projeto

O projeto está organizado em pacotes e classes, cada uma com uma responsabilidade específica. Abaixo está a explicação de cada classe:

### `BancodeDados.java`
- Classe principal para testes iniciais de conexão com o banco de dados.
- Estabelece a conexão com o banco PostgreSQL utilizando `DriverManager`.
- Insere um registro de exemplo na tabela `tab_cadastro`.

### `Cadastro.java`
- Representa o modelo de dados (entidade) do sistema.
- Contém os atributos `id`, `nome` e `idade`, que correspondem às colunas da tabela `tab_cadastro`.
- Possui métodos getters e setters para manipulação dos dados.

### `CadastroRepository.java`
- Responsável por realizar as operações de CRUD no banco de dados.
- Métodos disponíveis:
  - `inserir(Cadastro cadastro)`: Insere um novo registro na tabela.
  - `atualizar(Cadastro cadastro)`: Atualiza um registro existente com base no `id`.
  - `excluir(Integer id)`: Exclui um registro com base no `id`.
  - `listarTodos()`: Retorna uma lista com todos os registros da tabela.
  - `buscarPorId()`: Busca e exibe um registro específico com base no `id`.

### `SistemaCadastro.java`
- Classe principal do sistema.
- Demonstra o uso do repositório para listar todos os registros da tabela `tab_cadastro`.
- Exibe os dados no console.

### `ServerConexao.java`
- Gerencia a conexão com o banco de dados.
- Contém o método `getConexao()` utilizado em `CadastroRepository`.

## Tecnologias Utilizadas
- **Java**
- **Maven** (gerenciamento de dependências)
- **PostgreSQL** (banco de dados relacional)
- **JDBC** (para conexão e manipulação do banco de dados)

## Como Executar
1. Configure o banco de dados PostgreSQL e crie a tabela `tab_cadastro` com as colunas `id`, `nome` e `idade`.
2. Atualize as credenciais de conexão no código (`BancodeDados.java` ou `ServerConexao.java`).
3. Compile e execute o projeto utilizando sua IDE ou linha de comando.

## Estrutura da Tabela `tab_cadastro`
```sql
CREATE TABLE public.tab_cadastro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    idade INT
);
