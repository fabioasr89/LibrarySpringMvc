package com.fabio.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fabio.model.Autore;
import com.fabio.model.Genere;

public class GenereDAO extends AbstractDAO<Genere>{

	public GenereDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Genere> getAllGeneri(){
		Session session=null;
		Query q=null;
		List<Genere> lista=null;
		try {
			session=getSessionFactory().openSession();
			q=session.createQuery(getProperties().getProperty("query.getAllGenere"));
			lista=q.list();
		}catch(Exception e) {
			e.printStackTrace();
			lista=new ArrayList<Genere>();
		}
		return lista;
	}
	
	/**Metodo che recupera una lista di autori corrispondenti agli id passati come parametro*/
	public Set<Genere> getGenereForID(Integer[] id){
		Session session=null;
		Set<Genere> generi=null;
		List<Genere> lista=null;
		Query q=null;
		try {
			session=getSessionFactory().openSession();
			q=session.createQuery(getProperties().getProperty("query.getGeneriForId"));
			q.setParameterList("lista",id);
			lista=q.list();
			if(lista!=null) {
				generi=new LinkedHashSet(lista);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return generi;
	}
}
