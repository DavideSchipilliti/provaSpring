package it.perigea.provaSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.perigea.provaSpring.entities.Autore;
import it.perigea.provaSpring.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	AutoreRepository repository;
	
	public Iterable<Autore> getAllAutori() {
		return repository.findAll();
	}
	
	public Optional<Autore> getById(Long id) {
		return repository.findById(id);
	}
	
	public Autore saveAutore(Autore autoreDaSalvare) {
		repository.save(autoreDaSalvare);
		return autoreDaSalvare;
	}

	public Autore deleteById(Long id) {
		Autore autoreDaEliminare=repository.findById(id).get();
		repository.deleteById(id);
		return autoreDaEliminare;
	}
	
	public Autore deleteAutore(Autore autoreDaEliminare) {
		repository.delete(autoreDaEliminare);
		return autoreDaEliminare;
	}
	
	public Iterable<Autore> getByNome(String nome) {
		return repository.findAllByNome(nome);
	}

}
