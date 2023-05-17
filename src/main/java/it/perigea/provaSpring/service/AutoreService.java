package it.perigea.provaSpring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.perigea.provaSpring.entities.Autore;
import it.perigea.provaSpring.entities.dto.AutoreDto;
import it.perigea.provaSpring.entities.dto.AutoreMapper;
import it.perigea.provaSpring.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	AutoreRepository repository;
	
	@Autowired
	AutoreMapper mapper;
	
	public List<AutoreDto> getAllAutori() {
		List<Autore> autori = repository.findAll();
		List<AutoreDto> autoriDto = mapper.listAutoriToListAutoriDto(autori);
		return autoriDto;
	}
	
	public AutoreDto getById(Long id) {
		Autore autore=repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Autore con id=" + id + " non presente nel DataBase."));
		AutoreDto autoreDto= mapper.autoreToAutoreDto(autore);
		return autoreDto;
	}
	
	public AutoreDto getByCodFiscale(String codFiscale) {
		Autore autore=repository.findByCodFiscale(codFiscale).orElseThrow(() -> new EntityNotFoundException("Autore con Codice Fiscale=" + codFiscale + " non presente nel DataBase."));
		AutoreDto autoreDto= mapper.autoreToAutoreDto(autore);
		return autoreDto;
	}
	
	public AutoreDto saveOrUpdateAutore(AutoreDto autoreDtoDaSalvare) {
		String codFiscale=autoreDtoDaSalvare.getCodFiscale();
		Optional<Autore> autoreOptional =repository.findByCodFiscale(codFiscale);
		Autore autoreDaSalvare=new Autore();
		if(autoreOptional.isPresent())
			autoreDaSalvare= mapper.partialUpdate(autoreDtoDaSalvare, autoreOptional.get());
		else {
			autoreDaSalvare= mapper.autoreDtoToAutore(autoreDtoDaSalvare);
		}
		repository.save(autoreDaSalvare);
		AutoreDto autoreSalvato=mapper.autoreToAutoreDto(autoreDaSalvare);
		return autoreSalvato;
	}

	public AutoreDto deleteById(Long id) {
		Autore autoreDaEliminare=repository.findById(id).orElseThrow( () -> new EntityNotFoundException("Autore con id=" + id + " non presente nel DataBase."));
		repository.deleteById(id);
		return mapper.autoreToAutoreDto(autoreDaEliminare);
	}
	
	public AutoreDto deleteByCodFiscale(String codFiscale) {
		Autore autoreDaEliminare=repository.findByCodFiscale(codFiscale).orElseThrow( () -> new EntityNotFoundException("Autore con id=" + codFiscale + " non presente nel DataBase."));
		repository.deleteByCodFiscale(codFiscale);
		return mapper.autoreToAutoreDto(autoreDaEliminare);
	}
	
	public AutoreDto deleteAutore(AutoreDto autoreDtoDaEliminare) {
		String codFiscale = autoreDtoDaEliminare.getCodFiscale();
		Autore autoreDaEliminare = repository.findByCodFiscale(codFiscale).orElseThrow( () -> new EntityNotFoundException("Autore non presente nel DataBase."));
		repository.delete(autoreDaEliminare);
		return mapper.autoreToAutoreDto(autoreDaEliminare);
	}
	
	public List<AutoreDto> getByNome(String nome) {
		List<Autore> autori = repository.findAllByNome(nome);
		List<AutoreDto> autoriDto = mapper.listAutoriToListAutoriDto(autori);
		return autoriDto;
	}

}
