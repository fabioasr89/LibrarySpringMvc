package com.fabio.util;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.aspectj.util.FileUtil;

import com.fabio.bean.FileUploadBean;
import com.fabio.form.LibroForm;
import com.fabio.model.Autore;
import com.fabio.model.Libro;

public class UtilMethod {
	
	public UtilMethod() {
		// TODO Auto-generated constructor stub
	}
	
	public static void settaDescrizioni(List<Autore> autori) {
		try {
			if(autori!=null) {
				for(Autore auth:autori) {
					auth.generaDescrizione();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Libro convertiLibroForm(LibroForm o) {
		Libro libro=null;
		LibroForm libroForm=null;
		if(o!=null) {
			libroForm=(LibroForm)o;
			libro=new Libro();		
			libro.setTitolo(libroForm.getTitolo());
			libro.setDataInserimento(new Date());
			libro.setPubblicazione(libroForm.getPubblicazione());
		}
		return libro;
	}
	
	public static void processaLibroForm(LibroForm form) {
		Integer[] id=null;
		try {
			id=new Integer[form.getAutori().length];
			int i=0;
			for(Object o:form.getAutori()) {
				Integer idA=null;
				if(o instanceof Integer) {
					idA=(Integer)o;
					id[i]=idA;
					i++;
				}
			}
			form.setAutori(id);
			i=0;
			id=new Integer[form.getGenere().length];
			for(Object o:form.getGenere()) {
				Integer idA=null;
				if(o instanceof Integer) {
					idA=(Integer)o;
					id[i]=idA;
					i++;
				}
			}
			form.setGenere(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
}
