package it.perigea.provaSpring.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

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

import it.perigea.provaSpring.entities.dto.LibroDto;
import it.perigea.provaSpring.service.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<LibroDto>> getAllLibri() {
		List<LibroDto> listaLibriDto= service.getAllLibri();
		return new ResponseEntity<List<LibroDto>>(listaLibriDto, HttpStatus.OK);
	}
	
	@GetMapping("/getByIsbn/{isbn}")
	public ResponseEntity<LibroDto> getById(@PathVariable String isbn) {
		LibroDto libroDto=new LibroDto();
		try {
			libroDto=service.getByIsbn(isbn);
		}catch(EntityNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<LibroDto>(libroDto, HttpStatus.OK);
	}
	
	//se id già usato sostituisce il libro, altrimenti aggiunge nuovo libro
	@PutMapping("/addOrUpdateLibro")
	public ResponseEntity<LibroDto> addLibro(@RequestBody LibroDto libroDtoDaSalvare){
		LibroDto libroDtoSalvato=service.saveOrUpdateLibro(libroDtoDaSalvare);
		return new ResponseEntity<LibroDto>(libroDtoSalvato, HttpStatus.OK);
	}
	
	@PutMapping("/addAutoreToLibro/{isbn}/{codFiscale}")
	public ResponseEntity<LibroDto> addLibro(@PathVariable String isbn, @PathVariable String codFiscale){
		LibroDto libroDtoSalvato=service.addAutoreToLibro(isbn, codFiscale);
		return new ResponseEntity<LibroDto>(libroDtoSalvato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByIsbn/{isbn}")
	public ResponseEntity<LibroDto> delteByIsbn(@PathVariable String isbn) {
		LibroDto libroDtoEliminato= new LibroDto();
		try {
			libroDtoEliminato= service.deleteByIsbn(isbn);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<LibroDto>(libroDtoEliminato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<LibroDto> delteById(@PathVariable Long id) {
		LibroDto libroDtoEliminato= new LibroDto();
		try {
			libroDtoEliminato= service.deleteById(id);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<LibroDto>(libroDtoEliminato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLibro")
	public ResponseEntity<LibroDto> deleteLibro(@RequestBody LibroDto libroDtoDaEliminare){
		LibroDto libroDtoEliminato=service.deleteLibro(libroDtoDaEliminare);
		return new ResponseEntity<LibroDto>(libroDtoEliminato, HttpStatus.OK);
	}
	
	@GetMapping("/getByTitolo/{titolo}")
	public ResponseEntity<List<LibroDto>> getByTitolo(@PathVariable String titolo) {
		List<LibroDto> libriDto=service.getByTitolo(titolo);
		return new ResponseEntity<List<LibroDto>>(libriDto, HttpStatus.OK);
	}
	
	//aggiungere servizio per modificare parzialmente l'entità updatelibro
	//riceve un Dto non completo 
	//posso inserire questa possibilità in addLibro -> addOrUpdateLibro
	//se ne faccio due diversi addLibro deve dare errore se già esiste e viceversa updateLibro
}
