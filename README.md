# API para Sistema de Gerenciamento de Estoque para loja de Roupas

## Funcionalidades

### Rotas Publicas
- Login [público] `POST /login`
- Incluir Usuário [público] `POST /usuarios`

### Rotas Privadas

#### Produtos [Rota Privada]
- Cadastrar Produtos [privado/admin] `POST /produtos/cadastrar-produto`
- Listar Produtos [privado] `GET /produtos/listar-produtos`
- Listar Produtos por Código [privado] `GET /produtos/listar-por-codigo`
- Alterar Cadastro de Produto [privado/admin] `PUT /produtos/alterar/{id}`
- Excluir Produtos [privado/admin] `DELETE /produtos/excluir/{id}`

#### Fornecedores [Rota Privada para usuarios ADMIN]
- Cadastrar Fornecedores [privado/admin] `POST /fornecedores/cadastrar-fornecedor`
- Listar Fornecedores [privado/admin] `GET /fornecedores/listar-fornecedores`
- Listar Fornecedores por Código [privado/admin] `GET /fornecedores/listar-fornecedor-por-codigo`
- Alterar Cadastro de Fornecedor [privado/admin] `PUT /fornecedores/alterar-cadastro/{id}`
- Excluir Cadastro de Fornecedor [privado/admin] `DELETE /fornecedores/excluirFornecedor`

#### Estoque [Rota privada]
- Cadastrar (ENTRADA) Produto no Estoque [privado/admin] `POST /estoque/cadastrar-entrada`
- Listar Estoque [privado] `GET /estoque/listar`
- Vender (SAIDA) Produtos [privado] `PUT /estoque/vender/{id}/`
- Adicionar Produtos (ENTRADA) no estoque [privado/admin] `PUT /estoque/adicionar-produto/{id}`

## Dependências
- Java 11
- MySQL 8
- Criar objetos do banco de dados: `sql/SCHEMA.sql`
- Carga inicial: `sql/INSERT.sql`
- Arquivo do Postman: `sql/ProjetoIntegrador.postman_collection.json`
