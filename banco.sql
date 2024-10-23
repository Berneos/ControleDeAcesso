
DROP DATABASE controle_acesso;
CREATE DATABASE controle_acesso;
USE controle_acesso;

/* Tabela de Acessos */
/* 
public static int Id { get; set; }
public static Catraca catraca { get; set; }
public static Pessoa pessoa { get; set; }
public static Usuario usuario { get; set; }
public static DateTime dataAcesso { get; set; }
*/
/* Tabela tbacesso */
CREATE TABLE tbacesso (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    IdCatraca INT,
    IdPessoa INT,
    IdUsuario INT,
    dataAcesso DATETIME,
    FOREIGN KEY (IdCatraca) REFERENCES tbcatraca(Id),
	FOREIGN KEY (IdPessoa) REFERENCES tbpessoa(Id),
	FOREIGN KEY (IdUsuario) REFERENCES tbusuario(Id)	
);

/* Tabela Catraca */
/*
public static int Id { get; set; }
public static string CatracaNome { get; set; }
*/
CREATE TABLE tbcatraca (
Id INT AUTO_INCREMENT PRIMARY KEY,
CatracaNome VARCHAR(255)
);

INSERT INTO tbcatraca (CatracaNome) VALUES ('Catraca 1');
INSERT INTO tbcatraca (CatracaNome) VALUES ('Catraca 2');
INSERT INTO tbcatraca (CatracaNome) VALUES ('Catraca 3');
INSERT INTO tbcatraca (CatracaNome) VALUES ('Catraca 4');

SELECT * FROM tbcatraca;

/* Tabela Pessoa */
/*

public int Id { get; set; } 
public string PessoaName { get; set;}
public string PessoaCPF { get; set; }
public string PessoaTelefone { get; set; }

*/

CREATE TABLE tbpessoa (
Id INT AUTO_INCREMENT PRIMARY KEY,
PessoaName VARCHAR(255),
PessoaCPF VARCHAR (11),
PessoaTelefone VARCHAR (11)
);

/*
 public static int Id { get; set; }
 public string Nome { get; set; }
 public string Usuariio { get; set; }
 public string Senha { get; set; }
*/

CREATE TABLE tbusuario (
Id INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR (255),
Usuariio VARCHAR (255),
Senha VARCHAR (8)
);



