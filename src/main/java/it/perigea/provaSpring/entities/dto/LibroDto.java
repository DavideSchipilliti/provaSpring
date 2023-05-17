package it.perigea.provaSpring.entities.dto;

public class LibroDto {

	private String isbn;

	private String titolo;

	private Integer pagine;

	private Integer anno;

	private String nomeAutore;	//Voglio una stringa con nome e cognome
	private String cognomeAutore;

	//getter e setter
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getPagine() {
		return pagine;
	}
	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}
	public Integer getAnno() {
		return anno;
	}
	public void setAnno(Integer anno) {
		this.anno = anno;
	}
	public String getNome() {
		return nomeAutore;
	}
	public void setNome(String autore) {
		this.nomeAutore = autore;
	}
	public String getCognome() {
		return cognomeAutore;
	}
	public void setCognome(String cognome) {
		this.cognomeAutore = cognome;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
