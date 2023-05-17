package it.perigea.provaSpring.controller;


import java.util.List;

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

import it.perigea.provaSpring.entities.dto.AutoreDto;
import it.perigea.provaSpring.service.AutoreService;

@RestController
@RequestMapping("/autore")
public class AutoreController {
	
	@Autowired
	AutoreService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AutoreDto>> getAllAutori() {
		List<AutoreDto> listaAutoriDto= service.getAllAutori();
		return new ResponseEntity<List<AutoreDto>>(listaAutoriDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<AutoreDto> getById(@PathVariable Long id) {
		AutoreDto autoreDto=service.getById(id);
		return new ResponseEntity<AutoreDto>(autoreDto, HttpStatus.OK);
	}
	
	@GetMapping("/getByCodFiscale/{codFiscale}")
	public ResponseEntity<AutoreDto> getByCodFiscale(@PathVariable String codFiscale) {
		AutoreDto autoreDto=service.getByCodFiscale(codFiscale);
		return new ResponseEntity<AutoreDto>(autoreDto, HttpStatus.OK);
	}
	
	//se id già usato sostituisce l'autore, altrimenti aggiunge nuovo autore
	@PutMapping("/addOrUpdateAutore")
	public ResponseEntity<AutoreDto> addOrUpdateAutore(@RequestBody AutoreDto autoreDtoDaSalvare){
		AutoreDto autoreDtoSalvato=service.saveOrUpdateAutore(autoreDtoDaSalvare);
		return new ResponseEntity<AutoreDto>(autoreDtoSalvato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<AutoreDto> delteById(@PathVariable Long id) {
		AutoreDto autoreDtoEliminato= service.deleteById(id);
		return new ResponseEntity<AutoreDto>(autoreDtoEliminato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByCodFiscale/{codFiscale}")
	public ResponseEntity<AutoreDto> delteByCodFiscale(@PathVariable String codFiscale) {
		AutoreDto autoreDtoEliminato= service.deleteByCodFiscale(codFiscale);
		return new ResponseEntity<AutoreDto>(autoreDtoEliminato, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAutore")
	public ResponseEntity<AutoreDto> deleteAutore(@RequestBody AutoreDto autoreDtoDaEliminare){
		AutoreDto autoreDtoEliminato=service.deleteAutore(autoreDtoDaEliminare);
		return new ResponseEntity<AutoreDto>(autoreDtoEliminato, HttpStatus.OK);
	}
	
	@GetMapping("/getByNome/{nome}")
	public ResponseEntity<List<AutoreDto>> getByNome(@PathVariable String nome) {
		List<AutoreDto> listaAutoriDto= service.getByNome(nome);
		return new ResponseEntity<List<AutoreDto>>(listaAutoriDto, HttpStatus.OK);
	}
	
}
