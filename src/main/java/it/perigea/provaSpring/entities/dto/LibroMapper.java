package it.perigea.provaSpring.entities.dto;

import org.mapstruct.Mapper;

import it.perigea.provaSpring.entities.Libro;

@Mapper(componentModel = "spring")
public interface LibroMapper {

	LibroDto libroToLibroDto(Libro libro);


	Libro libroDtoToLibro(LibroDto libroDto);
}


/*
Per usare @Mapping(target = "name", expression = "java(simpleService.enrichName(source.getName()))")
devo fare una classe astratta
*/