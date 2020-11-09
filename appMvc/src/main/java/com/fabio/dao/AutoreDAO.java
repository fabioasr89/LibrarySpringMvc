package com.fabio.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fabio.model.Autore;

public class AutoreDAO extends AbstractDAO<Autore>{
	public AutoreDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Autore> getAllAutore(){
		List<Autore> lista=null;
		Session session=null;
		Query q=null;
		try {
			session=getSessionFactory().openSession();
			q=session.createQuery(getProperties().getProperty("query.getAllAutori"));
			lista=q.list();
		}catch(Exception e) {
			lista=new ArrayList<Autore>();
			e.printStackTrace();
		}
		return lista;
	}
	/**Metodo che recupera una lista di autori corrispondenti agli id passati come parametro*/
	public Set<Autore> getAutoreForID(Integer[] id){
		Session session=null;
		Set<Autore> autori=null;
		List<Autore> lista=null;
		Query q=null;
		try {
			session=getSessionFactory().openSession();
			q=session.createQuery(getProperties().getProperty("query.getAutoriForId"));
			q.setParameterList("lista",id);
			lista=q.list();
			if(lista!=null) {
				autori=new LinkedHashSet<Autore>(lista);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return autori;
	}
}
