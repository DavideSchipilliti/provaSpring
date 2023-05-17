package it.perigea.provaSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.perigea.provaSpring.entities.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {
	
	public Optional<Libro> findByIsbn(String isbn);
	
	public void deleteByIsbn(String isbn);
	
	public List<Libro> findAllByTitolo(String titolo);
	
}
