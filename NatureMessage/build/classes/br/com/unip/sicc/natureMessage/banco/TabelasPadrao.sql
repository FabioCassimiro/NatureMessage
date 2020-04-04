CREATE DATABASE NATUREMESSAGE2;
USE NATUREMESSAGE2;

/* 	CRIA TABELA DE USUÁRIO . */
 
CREATE TABLE TB_USUARIO(
NOPESSOA VARCHAR(90),
NOSOBRENOME VARCHAR(120),
NOCARGO VARCHAR(50),
NOEMPRESA VARCHAR(50),
NOENDERECO VARCHAR(250),
DTNASCIMENTO VARCHAR(11),
NOEMAIL VARCHAR(250),
NOLOGIN CHAR(20) PRIMARY KEY,
NOSENHA CHAR(50) NOT NULL
);

/* FIM CRIAÇÃO TABELA USUÁRIO */

/* 	CRIA TABELA DE SERVIDOR . */
CREATE TABLE TB_SERVIDOR(
CDIP char(15),
CDPORTA char(4),
NOHOSTNAME char(30),
CDHOSTNAME char(4)
);

/* FIM CRIAÇÃO TABELA SERVIDOR */

