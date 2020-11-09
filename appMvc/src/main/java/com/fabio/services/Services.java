package com.fabio.services;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
/**
 * @author FABIO PETRICOLA
 * 
 */
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fabio.bean.ResponseLibraryUtente;
import com.fabio.dao.AutoreDAO;
import com.fabio.dao.GenereDAO;
import com.fabio.dao.LibroDAO;
import com.fabio.dao.UtilDAO;
import com.fabio.form.LibroForm;
import com.fabio.model.Autore;
import com.fabio.model.Genere;
import com.fabio.model.Libro;

public class Services  implements ServicesInterface{
	@Autowired
	private AutoreDAO autoreDAO;
	@Autowired
	private LibroDAO libroDAO;
	@Autowired
	private GenereDAO genereDAO;
	@Autowired
	private UtilDAO utilDAO;
	@Transactional(rollbackFor=Exception.class)
	public boolean inserisciLibro(Libro o,CommonsMultipartFile fileUpload,LibroForm form) throws Exception {
		boolean validaInserimento=false;
		FileOutputStream fileOut=null;
		BufferedOutputStream buff=null;
		Set<Autore> autori=null;
		Set<Genere> generi=null;
		try {
			if(o!=null && (fileUpload!=null && !fileUpload.isEmpty())) {
				//o.setCopertina(fileUpload.getOriginalFilename());
				o.setCopertina(fileUpload.getBytes());
				autori=autoreDAO.getAutoreForID(form.getAutori());
				generi=genereDAO.getGenereForID(form.getGenere());
				if(autori!=null && generi!=null) {
					if(!autori.isEmpty() && !generi.isEmpty()) {
						o.setAutori(autori);
						o.setGenere(generi);
						validaInserimento=libroDAO.inserisciLibro(o);
					}else {
						validaInserimento=false;
					}
				}
			}
		}catch(Exception e) {
			validaInserimento=false;
			e.printStackTrace();
		}finally {
			if(!validaInserimento) {
				//eseguiamo il rollBack
				throw new Exception();
			}
		}
		
		return validaInserimento;
	}

	public boolean inserisciAutore(Autore auth) throws Exception {
		return autoreDAO.insert(auth);
	}

	public List<Genere> tipologieGeneri() throws Exception {
		
		return null;
	}

	public List<Autore> getAllAutori() throws Exception {
		return autoreDAO.getAllAutore();
	}

	public AutoreDAO getAutoreDAO() {
		return autoreDAO;
	}

	public void setAutoreDAO(AutoreDAO autoreDAO) {
		this.autoreDAO = autoreDAO;
	}

	public LibroDAO getLibroDAO() {
		return libroDAO;
	}

	public void setLibroDAO(LibroDAO libroDAO) {
		this.libroDAO = libroDAO;
	}

	public GenereDAO getGenereDAO() {
		return genereDAO;
	}

	public void setGenereDAO(GenereDAO genereDAO) {
		this.genereDAO = genereDAO;
	}

	public List<Libro> getAllLibri() throws Exception {
		return libroDAO.getAllLibri();
	}
	
	public List<Genere> getAllGeneri(){
		return genereDAO.getAllGeneri();
	}
	
	public List<ResponseLibraryUtente> getResponseLibriUtente() throws Exception {
		return utilDAO.getResponseLibriUtente();
	}

	public UtilDAO getUtilDAO() {
		return utilDAO;
	}

	public void setUtilDAO(UtilDAO utilDAO) {
		this.utilDAO = utilDAO;
	}
	
	
	

	
	
}
