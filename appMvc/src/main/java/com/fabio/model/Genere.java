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

@Entity
@Table(name="genere")
public class Genere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_GENERE")
	private Integer idGenere;
	
	@Column(name="GENERE")
	private String genere;
	
	@ManyToMany(mappedBy="genere")
	private Set<Libro> libri;
	
	public Integer getIdGenere() {
		return idGenere;
	}

	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
	
	
}
