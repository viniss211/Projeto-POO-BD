#SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
#SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
#SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS projeto_bd_poo DEFAULT CHARACTER SET utf8 ;
#DROP SCHEMA IF EXISTS projeto_bd_poo;
USE projeto_bd_poo ;

CREATE TABLE IF NOT EXISTS Autor (
  Nome VARCHAR(45) NOT NULL,
  Especializacao VARCHAR(45),
  Literatura VARCHAR(45),
  PRIMARY KEY (Nome))
engine = InnoDB;

CREATE TABLE IF NOT EXISTS Livro (
  idLivro INT NOT NULL auto_increment,
  Nome VARCHAR(45) NULL,
  Ano_Lanc INT NULL,
  genero VARCHAR(45) NULL,
  Autor_nomeAutor VARCHAR(45) NOT NULL,
  #copias INT NULL,
  PRIMARY KEY (idLivro),
  CONSTRAINT fk_Livro_Autor
    FOREIGN KEY (Autor_nomeAutor)
    REFERENCES projeto_bd_poo.Autor (Nome)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
engine = InnoDB;

CREATE TABLE IF NOT EXISTS Leitor (
  idLeitor INT NOT NULL auto_increment,
  Nome VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  PRIMARY KEY (idLeitor)
  )engine = InnoDB;

CREATE TABLE IF NOT EXISTS emprestimo (
  idemprestimo INT NOT NULL auto_increment,
  Data_Pega VARCHAR(45) NULL,
  Data_Devolve VARCHAR(45) NULL,
  multa TINYINT NULL,
  valor_multa FLOAT NULL,
  Leitor_idLeitor INT NOT NULL,
  PRIMARY KEY (idemprestimo, Leitor_idLeitor),
  INDEX fk_emprestimo_Leitor1_idx (Leitor_idLeitor ASC) VISIBLE,
  CONSTRAINT fk_emprestimo_Leitor1
    FOREIGN KEY (Leitor_idLeitor)
    REFERENCES projeto_bd_poo.Leitor (idLeitor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
engine = InnoDB;

CREATE TABLE IF NOT EXISTS Livro_has_Alugador (
  Livro_Autor_nomeAutor VARCHAR(45) NOT NULL,
  Leitor_idLeitor INT NOT NULL,
  Titulo VARCHAR (45) NOT NULL, #REINICIAR BD PARA COLOCAR ESSA LINHA
  PRIMARY KEY (Livro_Autor_nomeAutor, Leitor_idLeitor),
  INDEX fk_Livro_has_Leitor_Leitor1_idx (Leitor_idLeitor ASC) VISIBLE,
  INDEX fk_Livro_has_Leitor_Livro1_idx (Livro_Autor_nomeAutor ASC) VISIBLE,
  CONSTRAINT fk_Livro_has_Leitor_Livro1
    FOREIGN KEY (Livro_Autor_nomeAutor)
    REFERENCES projeto_bd_poo.Livro (Autor_nomeAutor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Livro_has_Alugador_Alugador1
    FOREIGN KEY (Leitor_idLeitor)
    REFERENCES projeto_bd_poo.Leitor (idLeitor)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    



INSERT INTO Autor (Nome,Especializacao,Literatura) VALUES ('Phelipe Montes','Suspense','Nacional');
INSERT INTO Autor (Nome,Especializacao,Literatura) VALUES ('Clarice Lispector','Poética','Nacional');
INSERT INTO Autor (Nome,Especializacao,Literatura) VALUES ('Graciliano Ramos','Romance','Nacional');
INSERT INTO Autor (Nome,Especializacao,Literatura) VALUES ('Jeff Kinney','Cartunista','Estrangeira');

insert into Livro (Nome,Ano_Lanc,genero,Autor_nomeAutor) values ('Romace1',2002,'romance','Phelipe Montes');
insert into Livro (Nome,Ano_Lanc,genero,Autor_nomeAutor) values ('Diario de um banana',2009,'Comédia','Jeff Kinney');
insert into Livro (Nome,Ano_Lanc,genero,Autor_nomeAutor) values ('Vidas Secas',1892,'romance','Graciliano Ramos');

insert into Leitor (Nome,cpf,telefone) value ('Vinicius de Souza',11111111111,991234567);
insert into Leitor (Nome,cpf,telefone) value ('Ana Clara Barata',22222222222,988786502);
insert into Leitor (Nome,cpf,telefone) value ('Flávia Lima',3333333333,999887621);

INSERT INTO emprestimo (Data_Pega, Data_Devolve, multa, valor_multa, Leitor_idLeitor)
VALUES ('2023-11-26', '2023-12-10', 0, 0.00, 1);

INSERT INTO Livro_has_Alugador (Livro_Autor_nomeAutor, Leitor_idLeitor, Titulo)
VALUES ('Graciliano Ramos', 1, 'Vidas Secas');


SET SQL_SAFE_UPDATES = 0;

SELECT * FROM Livro_has_Alugador;
SELECT * FROM emprestimo;
SELECT * FROM Autor;
SELECT * FROM Livro;
SELECT * FROM Leitor;

#delete from Leitor;
#delete from Autor;
#delete from Livro;
#delete from emprestimo;
#delete from Livro_has_Alugador;
#SET SQL_MODE=@OLD_SQL_MODE;
#SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
#SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
