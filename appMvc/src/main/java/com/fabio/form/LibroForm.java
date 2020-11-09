package com.fabio.form;


import java.util.List;


public class LibroForm {
	private Integer idLibro;
	private String titolo;
	private java.util.Date pubblicazione;
	private java.util.Date dataInserimento;
	private Integer[] autori;
	private Integer[] genere;
	private String path;
	
	public LibroForm() {
		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	

	public java.util.Date getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(java.util.Date pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public java.util.Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(java.util.Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	


	

	public Integer[] getAutori() {
		return autori;
	}

	public void setAutori(Integer[] autori) {
		this.autori = autori;
	}

	public Integer[] getGenere() {
		return genere;
	}

	public void setGenere(Integer[] genere) {
		this.genere = genere;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
