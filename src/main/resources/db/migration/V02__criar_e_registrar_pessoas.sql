CREATE TABLE pessoa(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN NOT NULL,
	logradouro VARCHAR(30),
	cep VARCHAR(30),
	bairro VARCHAR(30),
	complemento VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	numero VARCHAR(30)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO pessoa(nome,ativo,logradouro,cep,bairro,complemento,cidade,estado,numero) values ('Eduardo',true,'dvdfd','58420-255','fdfdfd','gfggf','dfdfdf','fdfdfdf','dfdfd');
INSERT INTO pessoa(nome,ativo,logradouro,cep,bairro,complemento,cidade,estado,numero) values ('Eduardo',true,'feffe','58420-255','fdcdcfd','gfggf','dfdfdf','fdfdfdf','dfdfd');
INSERT INTO pessoa(nome,ativo,logradouro,cep,bairro,complemento,cidade,estado,numero) values ('Eduardo',true,NULL,NULL,NULL,NULL,NULL,NULL,NULL);