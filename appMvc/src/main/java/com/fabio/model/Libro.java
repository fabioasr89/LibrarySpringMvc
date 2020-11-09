package com.fabio.model;
import java.util.Date;
/**
 * @author FABIO PETRICOLA
 * 
 */
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="libri")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LIBRO")
	private Integer idLibro;
	
	@Column(name="TITOLO")
	private String titolo;
	@Column(name="PUBBLICAZIONE")
	private Date pubblicazione;
	@Column(name="DATA_INSERIMENTO")
	private java.util.Date dataInserimento;
	@Column(name="COPERTINA")
	private byte[] copertina;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="libriperautore",
			joinColumns= {@JoinColumn(name="ID_LIBRO")},
			inverseJoinColumns= {@JoinColumn(name="ID_AUTORE")}
	)
	private Set<Autore> autori;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="libripergenere",
			joinColumns= {@JoinColumn(name="ID_LIBRO")},
			inverseJoinColumns= {@JoinColumn(name="ID_GENERE")}
	)
	private Set<Genere> genere;
	
	
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Date getPubblicazione() {
		return pubblicazione;
	}
	public void setPubblicazione(Date pubblicazione) {
		this.pubblicazione = pubblicazione;
	}
	public java.util.Date getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(java.util.Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	
	public byte[] getCopertina() {
		return copertina;
	}
	public void setCopertina(byte[] copertina) {
		this.copertina = copertina;
	}
	public Set<Autore> getAutori() {
		return autori;
	}
	public void setAutori(Set<Autore> autori) {
		this.autori = autori;
	}
	public Set<Genere> getGenere() {
		return genere;
	}
	public void setGenere(Set<Genere> genere) {
		this.genere = genere;
	}
	
	
}
