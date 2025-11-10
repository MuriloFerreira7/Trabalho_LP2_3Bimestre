create database academias;
use academias;

create table pessoa(
	id int primary key auto_increment,
    nome varchar(150),
    cpf varchar(15) not null,
    rg varchar(45),
    email varchar(150),
    telefone varchar(50),
    dataDeNascimento varchar(150),
    necessidadeEspecial varchar(150)
);

create table advertencia(
	id int primary key auto_increment,
    motivo varchar(500),
    penalidade varchar(500),
    data varchar(500),
    id_pessoa int,
    foreign key(id_pessoa) references pessoa(id)
);

create table aluno(
    id int primary key auto_increment,
    id_pessoa int,
    objetivo varchar(20),
    foreign key(id_pessoa) references pessoa(id)
);

create table avaliacaoFisica(
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
    foreign key (id_aluno) references aluno(id)
);

create table funcionario(
	id int primary key auto_increment,
    id_pessoa int,
    areaAtuacao varchar(150),
    salario varchar(100),
    foreign key(id_pessoa) references pessoa(id)
);

create table exercicio(
	id int primary key auto_increment,
    nome varchar(100),
    conjuntoMuscularAlvo varchar(100),
    nivelDeDificuldade varchar(100)
);

create table musculo (
	id int primary key auto_increment,
    nome varchar(150) not null
);

create table exercicio_musculo(
	exercicio_id int,
    musculo_id int,
    tipo enum('principal','secundario') not null,
    primary key(exercicio_id, musculo_id, tipo),
    foreign key (exercicio_id) references exercicio(id),
    foreign key (musculo_id) references musculo(id)
);

create table area(
	id int primary key auto_increment,
    nome varchar(100)
);

create table area_exercicio(
	id_exercicio int not null,
    id_area int not null,
    primary key(id_exercicio, id_area),
    foreign key (id_exercicio) references exercicio(id),
    foreign key (id_area) references area(id)
);

create table academia(
	id int primary key auto_increment,
    nome varchar(100),
    endereco varchar(200),
    horarioDeFuncionamento varchar(200)
);

create table academia_aluno(
	id_aluno int not null,
    id_academia int not null,
    primary key(id_aluno, id_academia),
    foreign key(id_aluno) references aluno(id),
    foreign key(id_academia) references academia(id)
);

create table academia_funcionario(
	id_funcionario int not null,
    id_academia int not null,
    primary key(id_funcionario, id_academia),
    foreign key(id_funcionario) references funcionario(id),
    foreign key(id_academia) references academia(id)
);

create table academia_area(
	id_area int not null,
    id_academia int not null,
    primary key(id_area, id_academia),
    foreign key(id_area) references area(id),
    foreign key(id_academia) references academia(id)
);

																												
