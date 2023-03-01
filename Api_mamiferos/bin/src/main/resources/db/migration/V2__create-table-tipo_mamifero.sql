create table tipo_mamifero(

    id_tipo bigint not null auto_increment,
    nome_tipo varchar(50) not null,
    pelo boolean not null,
    mamilos boolean not null,
    marsupio boolean not null,
    placenta boolean not null,


    primary key(id_tipo)

);