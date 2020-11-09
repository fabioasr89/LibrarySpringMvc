package com.fabio.services;
/**
 * @author FABIO PETRICOLA
 * 
 */
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fabio.bean.ResponseLibraryUtente;
import com.fabio.model.Autore;
import com.fabio.model.Genere;
import com.fabio.model.Libro;

public interface ServicesInterface {
	boolean inserisciAutore(Autore auth) throws Exception;
	List<Libro> getAllLibri() throws Exception;
	List<Genere> getAllGeneri() throws Exception; 
	List<Autore> getAllAutori() throws Exception;
	List<ResponseLibraryUtente> getResponseLibriUtente() throws Exception;
	
}
