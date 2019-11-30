CREATE TABLE usuario(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario(email,senha,nome) values ("eduardo@gmail.com","$2a$10$JlGEvjjRiGnDktLfDI8ZI.ckUEDUX/kyF2HczswFYg.XhTqssJfL6","eduardo")