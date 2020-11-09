package com.fabio.dao;
import java.util.ArrayList;
/**
 * @author FABIO PETRICOLA
 * 
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fabio.model.Libro;

public class LibroDAO extends AbstractDAO<Libro>{
	
	/**Metodo supplementare a quello scritto nell'abstracDao, per gestire più operazioni nella stessa transazione, come l'upload del file di copertina*/
	public boolean inserisciLibro(Libro lib) {
		boolean inserito=false;
		Session session=null;
		try {
			session=this.getSessionFactory().getCurrentSession();
			session.persist(lib);
			session.flush();
			inserito=true;
		}catch(Exception e) {
			inserito=false;
			e.printStackTrace();
		}
		return inserito;
	}
	
	public List<Libro> getAllLibri(){
		List<Libro> libri=null;
		Session session=null;
		Query q=null;
		try {
			session=getSessionFactory().openSession();
			q=session.createQuery(getProperties().getProperty("query.getAllLibri"));
			libri=q.list();
		}catch(Exception e){
			e.printStackTrace();
			libri=new ArrayList<Libro>();
		}
		return libri;
	}
	
	
}
