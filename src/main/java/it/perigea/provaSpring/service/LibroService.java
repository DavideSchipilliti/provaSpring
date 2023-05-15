package it.perigea.provaSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.perigea.provaSpring.entities.Libro;
import it.perigea.provaSpring.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository repository;

	
	public Iterable<Libro> getAllLibri() {
		return  repository.findAll() ;
	}
	
	public Optional<Libro> getById(Long id) {
		return repository.findById(id);
	}
	
	public Libro saveLibro(Libro libroDaSalvare) {
		repository.save(libroDaSalvare);
		return libroDaSalvare;
	}

	public Libro deleteById(Long id) {
		Libro libroDaEliminare=repository.findById(id).get();
		repository.deleteById(id);
		return libroDaEliminare;
	}
	
	public Libro deleteLibro(Libro libroDaEliminare) {
		repository.delete(libroDaEliminare);
		return libroDaEliminare;
	}
	
	public Iterable<Libro> getByTitolo(String titolo) {
		return repository.findAllByTitolo(titolo);
	}
	
}
