/**
 * 
 * @author Fabio Petricola
 */
package com.fabio.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fabio.form.LibroForm;

public class LibroFormValidator extends CheckValidator{
	private LibroForm bean;
	private boolean valido;
	public LibroFormValidator() {
		
	}

	@Override
	public void checkParameter() {
		Pattern pattern=null;
		Matcher match=null;
		
		if(bean!=null) {
			try {
				pattern=Pattern.compile(getRegexTesto());
				if(pattern!=null) {
					match=pattern.matcher(bean.getTitolo());
					valido=match.find();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public LibroForm getBean() {
		return bean;
	}

	public void setBean(LibroForm bean) {
		this.bean = bean;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	
	
}
