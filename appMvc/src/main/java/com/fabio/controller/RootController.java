package com.fabio.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author FABIO PETRICOLA
 * 
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabio.bean.AutoreFormValidator;
import com.fabio.bean.ResponseLibraryUtente;
import com.fabio.model.Libro;

@Controller
@RequestMapping(value="/")
public class RootController extends BaseController{
	private String param="0";
	@RequestMapping(value="")
	public String getIndex(HttpServletRequest request,HttpServletResponse response) {
		param="0";
		request.setAttribute("param", param);
		request.getSession().setAttribute("versione",getProperties().getProperty("versione"));
		return "index";
	}
	
	
	
	@RequestMapping(value="/getAllLibri")
	@ResponseBody
	public List<ResponseLibraryUtente> getAllLibri(){
		List<ResponseLibraryUtente> risposta=null;
		try {
			risposta=getServices().getResponseLibriUtente();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return risposta;
	}

	

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}




	
	
	

	
	
}
