create database academia;
use academia;
create table advertencias(
	id int primary key auto_increment,
    motivo varchar(500),
    penalidade varchar(500),
    data varchar(500),
    id_pessoa int,
    foreign key(id_pessoa) references pessoas
);

create table avaliacoesFisicas(
	id int primary key auto_increment,
    id_aluno int,
    bracoEsquerdo varchar(20),
    bracoDireito varchar(20),
    pernaEsquerda varchar(20),
    pernaDireita varchar(20),
    cintura varchar(20),
    abdomen varchar(20),
    busto varchar(20),
	pescoco varchar(20),
    gorduraCorporal varchar(20),
    bancoDeWells varchar(20),
    altura varchar(20),
    peso varchar(20),
    foreign key (id_aluno) references aluno
);

create table pessoas(
	id int primary key auto_increment,
    nome varchar(150),
    cpf varchar(15),
    rg varchar(45),
    email varchar(150),
    telefone varchar(50),
    dataDeNascimento varchar(150),
    necessidadeEspecial varchar(150),
);

create table alunos(
    id int primary key auto_increment,
    id_pessoa int,
    objetivo varchar(20),
    foreign key(id_pessoa) references pessoas
);

create table funcionarios(
	id int 
)



