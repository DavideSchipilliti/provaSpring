package it.perigea.provaSpring.entities.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoreDto {
	
	private String codFiscale;
	
	private String nome;
	
	private String cognome;
	
	private Date dataNascita;

	List<LibroDto> libri;	//Lista di stringe contenenti il titolo dei libri scritti
	
	public AutoreDto() {
		super();
		this.libri=new ArrayList<>();
	}
	
	//Getter e Setter
	/*
	 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
	 * } public String getNome() { return nome; } public void setNome(String nome) {
	 * this.nome = nome; } public String getCognome() { return cognome; } public
	 * void setCognome(String cognome) { this.cognome = cognome; } public Date
	 * getDataNascita() { return dataNascita; } public void setDataNascita(Date
	 * dataNascita) { this.dataNascita =dataNascita; } public List<String>
	 * getLibri() { return libri; } public void setLibri(List<String> libri) {
	 * this.libri = libri; }
	 */
}
