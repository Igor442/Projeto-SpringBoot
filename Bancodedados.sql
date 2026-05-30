create database farmacia;
use farmacia;

create table remedio (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_produto varchar(50),
    tipo varchar(50),
    preco double,
    quantidade int
);
