package it.perigea.provaSpring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.perigea.provaSpring.entities.Libro;
import it.perigea.provaSpring.service.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Libro>> getAllLibri() {
		Iterable<Libro> listaLibri= service.getAllLibri();
		return new ResponseEntity<Iterable<Libro>>(listaLibri, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Libro> getById(@PathVariable Long id) {
		Optional<Libro> libroOptional=service.getById(id);
		if ( libroOptional.isPresent() ) {
			Libro libro= libroOptional.get();
			return new ResponseEntity<Libro>(libro, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}
	
	//se id già usato sostituisce il libro, altrimenti aggiunge nuovo libro
	@PutMapping("/addLibro")
	public ResponseEntity<Libro> addLibro(@RequestBody Libro libroDaSalvare){
		Libro libroSalvato=service.saveLibro(libroDaSalvare);
		return new ResponseEntity<Libro>(libroSalvato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Libro> delteById(@PathVariable Long id) {
		Libro libroEliminato= service.deleteById(id);
		return new ResponseEntity<Libro>(libroEliminato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLibro")
	public ResponseEntity<Libro> deleteLibro(@RequestBody Libro libroDaEliminare){
		Libro libroEliminato=service.deleteLibro(libroDaEliminare);
		return new ResponseEntity<Libro>(libroEliminato, HttpStatus.OK);
	}
	
	@GetMapping("/getByTitolo/{titolo}")
	public ResponseEntity<Iterable<Libro>> getByTitolo(@PathVariable String titolo) {
		Iterable<Libro> libri=service.getByTitolo(titolo);
		return new ResponseEntity<Iterable<Libro>>(libri, HttpStatus.OK);
	}
	
}
