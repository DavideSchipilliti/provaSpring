package it.perigea.provaSpring.repository;

import org.springframework.data.repository.CrudRepository;

import it.perigea.provaSpring.entities.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long>{
	
	public Iterable<Autore> findAllByNome(String nome);
}
