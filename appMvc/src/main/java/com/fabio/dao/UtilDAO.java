package com.fabio.dao;
/**
 * 
 * @Autor Fabio Petricola
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fabio.bean.ResponseLibraryUtente;

public class UtilDAO extends AbstractDAO<UtilDAO>{
	public UtilDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<ResponseLibraryUtente> getResponseLibriUtente(){
		Session session=null;
		List<ResponseLibraryUtente> risposta=null;
		List<Object[]> obj=null;
		Query q=null;
		try {
			session=getSessionFactory().openSession();
			q=session.createSQLQuery(getProperties().getProperty("query.getLibriResponseView"));
			obj=q.list();
			if(obj!=null && obj.size()>0) {
				ResponseLibraryUtente response=null;
				risposta=new ArrayList<ResponseLibraryUtente>();
				for(Object[] rsp:obj) {
					response=new ResponseLibraryUtente();
					response.setTitolo((String)rsp[0]);
					response.setDataPubblicazione((Date)rsp[1]);
					response.setDataInserimento((Date)rsp[2]);
					response.setCopertina((byte[])rsp[3]);
					response.settaImmagine();
					risposta.add(response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			risposta=new ArrayList<ResponseLibraryUtente>();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return risposta;
	}


	
}
