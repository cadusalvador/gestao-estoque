/*==============================================================*/
/* Insert Table: fornecedores                                   */
/*==============================================================*/
INSERT INTO fornecedores (nome, endereco, cidade, estado, telefone) VALUES
('Fornecedor 1', 'Rua A, 123', 'Cidade A', 'Estado A', '(11) 1234-5678'),
('Fornecedor 2', 'Rua B, 456', 'Cidade B', 'Estado B',  '(22) 2345-6789'),
('Fornecedor 3', 'Rua C, 789', 'Cidade C', 'Estado C',  '(33) 3456-7890');


/*==============================================================*/
/* Insert Table: produtos                                       */
/*==============================================================*/
INSERT INTO produtos (nome, descricao, fornecedor_id) VALUES
('Produto 1', 'Biquini cor roxo', 1),
('Produto 2', 'Bone cor preta', 1),
('Produto 3', 'Calça cor azul', 2),
('Produto 4', 'Camisa cor vermelha', 2),
('Produto 5', 'Sapato cor preta e vermelha', 3),
('Produto 6', 'Camiseta cor bege', 3);

/*==============================================================*/
/* Insert Table: estoque                                        */
/*==============================================================*/
INSERT INTO estoque (quantidade, preco_unitario, movimento, data_movimento, produto_id, usuario_id) VALUES
(50, 19.99, 'ENTRADA', CURRENT_TIMESTAMP, 1, 1),
(2, 19.99, 'SAIDA', CURRENT_TIMESTAMP, 1, 2),
(30, 19.99, 'ENTRADA', CURRENT_TIMESTAMP, 2, 1),
(4, 19.99, 'SAIDA', CURRENT_TIMESTAMP, 2, 3),
(50, 19.99, 'ENTRADA', CURRENT_TIMESTAMP, 3, 1),
(6, 19.99, 'SAIDA', CURRENT_TIMESTAMP, 3, 3),
(50, 19.99, 'ENTRADA', CURRENT_TIMESTAMP, 4, 1),
(2, 19.99, 'SAIDA', CURRENT_TIMESTAMP, 4, 2),
(30, 19.99, 'ENTRADA', CURRENT_TIMESTAMP, 5, 1),
(4, 19.99, 'SAIDA', CURRENT_TIMESTAMP, 5, 2),
(50, 19.99, 'ENTRADA', CURRENT_TIMESTAMP, 6, 1),
(6, 19.99, 'SAIDA', CURRENT_TIMESTAMP, 6, 3);

/*==============================================================*/
/* Insert Table: usuarios                                       */
/*==============================================================*/
INSERT INTO usuarios (nome, login, senha, ativo) VALUES
('Dono', 'dono_loja', '1234', TRUE),
('Vendedor 1', 'vendedor_1', '4567', TRUE),
('Vendedor 2', 'vendedor_2', '8901', TRUE);

/*==============================================================*/
/* Insert Table: permissao                                      */
/*==============================================================*/
INSERT INTO permissao (denominacao, usuario_id) VALUES
('ADMIN', 1),
('USUARIO', 2),
('USUARIO', 3);