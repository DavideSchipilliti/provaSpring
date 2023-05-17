package it.perigea.provaSpring.entities.dto;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import it.perigea.provaSpring.entities.Autore;

//Per mappare la lista di Libro in lista di LibroDto dico di usare la classe LibroMapper.
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {LibroMapper.class})
public interface AutoreMapper {
	//Se voglio fare un attributo libri di tipo List<String> (contenente i titolo) si converte in automatico in string? come?
	//@Mapping(target = "titoloLibri", expression = "java(autore.getLibri().stream().map(Libro::getTitolo).collect(Collectors.toList())")
	
	AutoreDto autoreToAutoreDto (Autore autore);
	
	@Mapping(target= "id", ignore=true)
	Autore autoreDtoToAutore (AutoreDto autoreDto);
	
	@InheritConfiguration(name = "autoreDtoToAutore")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Autore partialUpdate(AutoreDto autoreDto, @MappingTarget Autore autore);
	
	List<AutoreDto> listAutoriToListAutoriDto (List<Autore> listaAutori);
	
	List<Autore> listAutoriDtoToListAutori (List<AutoreDto> listaAutoriDto);

}
