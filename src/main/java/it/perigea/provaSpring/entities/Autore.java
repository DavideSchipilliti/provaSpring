package it.perigea.provaSpring.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Autore {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column(name="DATA_NASCITA")
	@Temporal(TemporalType.DATE)
	private Date dataNascita;

	@OneToMany(mappedBy="autore", cascade = CascadeType.ALL)
	List<Libro> libri;
	
	public Autore() {
		super();
		this.libri=new ArrayList<>();
	}
	
	//Getter e Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita =dataNascita;
	}
	private List<Libro> getLibri() {	//messo private per non far stampare la lista
		return libri;
	}
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	 
}
