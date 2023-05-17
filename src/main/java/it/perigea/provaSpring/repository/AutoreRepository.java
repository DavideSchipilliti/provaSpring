package it.perigea.provaSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.perigea.provaSpring.entities.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long>{
	
	public List<Autore> findAllByNome(String nome);

	public Optional<Autore> findByCodFiscale(String codFiscale);

	public void deleteByCodFiscale(String codFiscale);
}
