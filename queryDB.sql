CREATE TABLE libro(
	id serial Primary Key,
	titolo varchar (50) NOT NULL,
	pagine int,
	anno int,
	scritto_da int references autore(id) );
	
CREATE TABLE autore(
	id serial primary key,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	data_nascita date );

insert into autore (nome, cognome)
values ('nome1', 'cognome1');

insert into libro (titolo, pagine, anno, scritto_da)
values ('titolo1', 150, 1995, 1),
('titolo2', 150, 2000, 1),
('titolo3', 150, 2010, 1),
('titolo4', 150, 2020, 1),
('titolo5', 150, 2023, 1);

Select * from libro
select * from autore


insert into libro (titolo, pagine, anno)
values ('titolo1', 150, 1997)