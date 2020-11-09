package com.fabio.bean;


import java.util.regex.Pattern;
import com.fabio.form.AutoreForm;
/**
 *  @author FABIO PETRICOLA
 * */


public class AutoreFormValidator extends CheckValidator{
	private AutoreForm bean;
	private boolean valido;
	
	public AutoreFormValidator() {
	}
	@Override
	public void checkParameter() {
		Pattern pattern=null;
		java.util.regex.Matcher match=null;
		try {
			pattern=Pattern.compile(getRegexTesto());		
			match=pattern.matcher(bean.getNome());
			valido=match.find();
			if(valido) {
				match=pattern.matcher(bean.getCognome());
				valido=match.find();
			}
		}catch(Exception e) {
			e.printStackTrace();		}
	}

	

	
	public AutoreForm getBean() {
		return bean;
	}
	public void setBean(AutoreForm bean) {
		this.bean = bean;
	}
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	

	
	
	
}
