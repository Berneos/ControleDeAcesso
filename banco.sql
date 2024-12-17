
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
SELECT * FROM tbacesso;
INSERT INTO tbacesso(IdCatraca,IdPessoa,IdUsuario,dataAcesso) VALUES (1,1,1,'2024-11-04 21:50:17');
DELETE FROM tbacesso WHERE Id = 4;
DROP TABLE tbacesso;

/* Tabela Catraca */
/*
public static int Id { get; set; }
public static string CatracaNome { get; set; }
*/
CREATE TABLE tbcatraca (
Id INT AUTO_INCREMENT PRIMARY KEY,
CatracaNome VARCHAR(255) NOT NULL
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
PessoaNome VARCHAR(255) NOT NULL,
PessoaCPF VARCHAR (11) NOT NULL,
PessoaTelefone VARCHAR (11) NOT NULL
);

DROP TABLE tbacesso;
DROP TABLE tbpessoa;

INSERT INTO tbpessoa(PessoaNome,PessoaCPF,PessoaTelefone) VALUES ("Hanna","12345678900","31967523644");
DELETE FROM tbpessoa WHERE (Id = 1);
UPDATE tbpessoa SET PessoaNome = 'Hanna' WHERE ID = 1;
SELECT * FROM tbpessoa;

/*
 public static int Id { get; set; }
 public string Nome { get; set; }
 public string Usuariio { get; set; }
 public string Senha { get; set; }
*/

CREATE TABLE tbusuario (
Id INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR (255) NOT NULL,
Usuariio VARCHAR (255) NOT NULL,
Senha VARCHAR (8) NOT NULL,
isAdmin BOOLEAN NOT NULL
);

INSERT INTO tbusuario(Nome,Usuariio,Senha,isAdmin) VALUES ("BnGames","Breno","123",true);
INSERT INTO tbusuario(Nome,Usuariio,Senha,isAdmin) VALUES ("Igor","Moneyballs","123",false);
INSERT INTO tbusuario(Nome,Usuariio,Senha,isAdmin) VALUES ("Skibidi toilet fanum tax","Dinheirobolas","123",true);
SELECT * FROM tbusuario;




