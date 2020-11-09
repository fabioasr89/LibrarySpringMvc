package com.fabio.model;

/**
 * @author FABIO PETRICOLA
 * 
 */
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="autori")
public class Autore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AUTORE")
	private Integer idAutore;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="COGNOME")
	private String cognome;

	public Integer getIdAutore() {
		return idAutore;
	}
	@ManyToMany(mappedBy="autori")
	private Set<Libro> libri;
	public void setIdAutore(Integer idAutore) {
		this.idAutore = idAutore;
	}
	
	@Transient
	private String descr;
	
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

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
	
	public void generaDescrizione() {
		this.descr=nome+" "+cognome;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
}
