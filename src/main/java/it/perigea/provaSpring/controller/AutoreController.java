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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.perigea.provaSpring.entities.Autore;
import it.perigea.provaSpring.service.AutoreService;

@RestController
@RequestMapping("/autore")
public class AutoreController {
	
	@Autowired
	AutoreService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Autore>> getAllAutori() {
		Iterable<Autore> listaAutori= service.getAllAutori();
		return new ResponseEntity<Iterable<Autore>>(listaAutori, HttpStatus.OK);
	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Autore> getById(@PathVariable Long id) {
		Optional<Autore> autoreOptional=service.getById(id);
		if ( autoreOptional.isPresent() ) {
			Autore autore= autoreOptional.get();
			return new ResponseEntity<Autore>(autore, HttpStatus.OK);
		}
		return null;
	}
	
	//se id già usato sostituisce l'autore, altrimenti aggiunge nuovo autore
	@PutMapping("/addAutore")
	public ResponseEntity<Autore> addAutore(@RequestBody Autore autoreDaSalvare){
		Autore autoreSalvato=service.saveAutore(autoreDaSalvare);
		return new ResponseEntity<Autore>(autoreSalvato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Autore> delteById(@PathVariable Long id) {
		Autore autoreEliminato= service.deleteById(id);
		return new ResponseEntity<Autore>(autoreEliminato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAutore")
	public ResponseEntity<Autore> deleteAutore(@RequestBody Autore autoreDaEliminare){
		Autore autoreEliminato=service.deleteAutore(autoreDaEliminare);
		return new ResponseEntity<Autore>(autoreEliminato, HttpStatus.OK);
	}
	
	@GetMapping("/getByNome/{nome}")
	public ResponseEntity<Iterable<Autore>> getByNome(@PathVariable String nome) {
		Iterable<Autore> listaAutori= service.getByNome(nome);
		return new ResponseEntity<Iterable<Autore>>(listaAutori, HttpStatus.OK);
	}
	
}
