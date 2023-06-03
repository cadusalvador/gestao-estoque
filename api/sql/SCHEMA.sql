/*==============================================================*/
/* Database name:  ProjetoIntegrador                            */
/* DBMS name:      MySQL 8.0                                    */
/* Created on:    25/04/2023   19:09                            */
/*==============================================================*/

use ProjetoIntegrador;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS produtos;
DROP TABLE IF EXISTS fornecedores;
DROP TABLE IF EXISTS estoque;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS permissao;
SET FOREIGN_KEYS_CHECKS=1;

/*==============================================================*/
/* Table: produtos                                              */
/*==============================================================*/
CREATE TABLE produtos
(
	id INTEGER AUTO_INCREMENT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	fornecedor_id INTEGER NOT NULL,
	PRIMARY KEY (id ASC),
	CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id)
			REFERENCES fornecedores (id)
			ON UPDATE CASCADE
			ON DELETE CASCADE
);

/*==============================================================*/
/* Table: fornecedores                                          */
/*==============================================================*/
CREATE TABLE fornecedores
(
	id INTEGER AUTO_INCREMENT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	endereco VARCHAR(255) NOT NULL,
	cidade VARCHAR(255) NOT NULL,
	estado VARCHAR(50) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	PRIMARY KEY (id ASC)
);

/*==============================================================*/
/* Table: estoque                                               */
/*==============================================================*/
CREATE TABLE estoque
(
	id INTEGER AUTO_INCREMENT NOT NULL,
	quantidade INTEGER NOT NULL,
	preco_unitario DECIMAL(10, 2) NOT NULL,
	movimento VARCHAR(50) NOT NULL,
	data_movimento TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	produto_id INTEGER NOT NULL,
	usuario_id INTEGER NOT NULL,
	PRIMARY KEY (id ASC),
	CONSTRAINT fk_produto FOREIGN KEY (produto_id)
			REFERENCES produtos (id),
	CONSTRAINT fk_usuario_estoque FOREIGN KEY (usuario_id)
			REFERENCES usuarios (id)
);

/*==============================================================*/
/* Table: usuarios                                              */
/*==============================================================*/
CREATE TABLE usuarios
(
	id INTEGER AUTO_INCREMENT NOT NULL,
	nome VARCHAR(100) NOT NULL,
	login VARCHAR(100) NOT NULL,
	senha VARCHAR(100) NOT NULL,
	ativo BOOLEAN NOT NULL,
	PRIMARY KEY (id ASC)
);

/*==============================================================*/
/* Table: permissao                                             */
/*==============================================================*/
CREATE TABLE permissao
(
	id INTEGER AUTO_INCREMENT NOT NULL,
	denominacao VARCHAR(255) NOT NULL,
	usuario_id INTEGER NOT NULL,
	PRIMARY KEY (id ASC),
	CONSTRAINT fk_usuario FOREIGN KEY (usuario_id)
		REFERENCES usuarios (id)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

