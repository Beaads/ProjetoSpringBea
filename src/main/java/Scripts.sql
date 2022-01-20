SELECT * FROM PRODUTO;
SELECT * FROM CLIENTE;
SELECT * FROM FUNCIONARIO;
SELECT * FROM LOJA;

DROP TABLE LOJA;
DROP TABLE CLIENTE;
DROP TABLE PRODUTO;

CREATE TABLE PRODUTO(
	idProduto BIGSERIAL PRIMARY KEY not null,
	nome VARCHAR(60),
	quantidade int,
	preço numeric
);

CREATE TABLE CLIENTE(
	idCliente BIGSERIAL PRIMARY KEY not null,
	idade int,
	nome VARCHAR(60),
	valorParaGastar numeric
);

CREATE TABLE funcionario
(
    idfuncionario bigserial NOT NULL PRIMARY KEY,
    nome VARCHAR(255),
    idade int,
    setor VARCHAR(255)
)

INSERT INTO CLIENTE (nome, idade, valorParaGastar) VALUES(
	'Maria','96','1000.00')
	('Rafaela','20', '50.00'),
('Amanda','18', '40.00'),
('Julia','22', '80.00');

INSERT INTO PRODUTO (nome, quantidade, preço) VALUES(
'Caixa Pizza','10', '50.00'),
('Caixa bolo','0', '90.00'),
('Caixa correio','5', '70.00');

DROP TABLE VENDAPRODUTO;

CREATE TABLE VENDAPRODUTO (
	numeroDaVenda BIGSERIAL PRIMARY KEY not null,
	idProduto int not null,
    idCliente int not null,
    idfuncionario int not null,
    quantidade int not null,
		foreign key (idProduto) references produto(idproduto),
		foreign key (idCliente) references cliente(idCliente),
		foreign key (idfuncionario) references funcionario(idfuncionario)
)

SELECT * FROM VENDAPRODUTO;

SELECT idFuncionario FROM FUNCIONARIo


SELECT numerodavenda, idProduto, idCliente, idFuncionario, Quantidade FROM VENDAPRODUTO WHERE numerodavenda = 2


SELECT * FROM CLIENTE WHERE idCliente = 1




