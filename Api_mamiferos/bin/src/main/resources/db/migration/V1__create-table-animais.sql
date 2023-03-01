create table animais(

    id bigint not null auto_increment,
    nome varchar(50) not null,
    cor varchar(15) not null,
    peso double not null,
    tipo varchar(15) not null,
    tipo_sangue varchar(10) not null,
    pelo boolean not null,
    glandulas_mamarias boolean not null,
    patas int not null,

    primary key(id)

);