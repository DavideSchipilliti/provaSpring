package it.perigea.provaSpring.entities.dto;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import it.perigea.provaSpring.entities.Libro;

@Mapper(componentModel = "spring")
public interface LibroMapper {

	@Mapping(target = "nome", source = "libro.autore.nome")
	@Mapping(target = "cognome", source = "libro.autore.cognome")
	LibroDto libroToLibroDto(Libro libro);

	@InheritInverseConfiguration(name= "libroToLibroDto")	//fa in automatico l'inverso del mapping
	@Mapping(target= "id", ignore=true)
	Libro libroDtoToLibro(LibroDto libroDto);
	
	@InheritConfiguration(name = "libroDtoToLibro")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Libro partialUpdate(LibroDto libroDTO, @MappingTarget Libro libro);
	//questo metodo serve per non sovrascrivere l'entità modificando gli eventuali campi popolati in null nel caso il dto non sia completo.
	//devo aver già preso l'entità dal db e passarla in ingresso
	
	List<Libro> listaLibriDtoToListaLibri(List<LibroDto> listaLibriDto);
	
	List<LibroDto> listaLibriToListaLibriDto(List<Libro> listaLibriDto);
}