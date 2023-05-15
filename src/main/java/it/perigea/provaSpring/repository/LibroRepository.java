package it.perigea.provaSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.perigea.provaSpring.entities.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {
	
	public Iterable<Libro> findAllByTitolo(String titolo);
	
}
