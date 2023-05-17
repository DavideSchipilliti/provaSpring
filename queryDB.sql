CREATE TABLE autore(
	id serial primary key,
	cod_fiscale varchar (50) unique not null,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	data_nascita date );

CREATE TABLE libro(
	id serial Primary Key,
	isbn varchar (50) unique not null,
	titolo varchar (50) NOT NULL,
	pagine int,
	anno int,
	scritto_da int references autore(id) );


insert into autore (nome, cognome, cod_fiscale)
values ('nome1', 'cognome1', '0000000001');

insert into libro (titolo, isbn, pagine, anno, scritto_da)
values ('titolo1', 'aaaaa', 150, 1995, 1),
('titolo2', 'aaaab', 150, 2000, 1),
('titolo3', 'aaaac', 150, 2010, 1),
('titolo4', 'aaaad', 150, 2020, 1),
('titolo5', 'aaaae', 150, 2023, 1);

Select * from libro
select * from autore


insert into libro (titolo, pagine, anno)
values ('titolo1', 150, 1997)