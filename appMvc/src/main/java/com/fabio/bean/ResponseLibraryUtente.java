package com.fabio.bean;

import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQuery;

public class ResponseLibraryUtente {
	private Integer idLibro;
	private String titolo;
	private String nomeAutore;
	private String cognomeAutore;
	private Date dataPubblicazione;
	private String genere;
	private Date dataInserimento;
	private byte[] copertina;
	private String img;
	public ResponseLibraryUtente() {
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getCognomeAutore() {
		return cognomeAutore;
	}

	public void setCognomeAutore(String cognomeAutore) {
		this.cognomeAutore = cognomeAutore;
	}

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public byte[] getCopertina() {
		return copertina;
	}

	public void setCopertina(byte[] copertina) {
		this.copertina = copertina;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void settaImmagine() {
		if(this.copertina!=null) {
			img=Base64.getEncoder().encodeToString(this.copertina);
		}else {
			img="";
		}
	}
	
}
