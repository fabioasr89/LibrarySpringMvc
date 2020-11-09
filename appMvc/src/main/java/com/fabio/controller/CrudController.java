package com.fabio.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fabio.bean.AutoreFormValidator;
import com.fabio.bean.LibroFormValidator;
import com.fabio.form.AutoreForm;
import com.fabio.form.LibroForm;
import com.fabio.model.Autore;
import com.fabio.model.Genere;
import com.fabio.model.Libro;
import com.fabio.util.UtilMethod;

@Controller
@RequestMapping(value="CrudController/")
public class CrudController extends BaseController{
	private List<Autore> allAutori=null;
	private Libro libro;
	private List<Genere> allGeneri;
	//param è un valore che ci serve per indivuduare le operazioni disponibili
	//con param=1 settiamo le operazioni sull'autore
	private String param="1";
	private Map<String,Object> mappaEsiti;
	@Autowired
	private AutoreFormValidator autoreFormValidator;
	@Autowired
	private LibroFormValidator libroFormValidator;
	@Autowired
	private Properties properties;
	public CrudController() {
		
	}
	

	@RequestMapping(value="insertIndex")
	public String indexInsert(Model model,HttpServletRequest request,HttpServletResponse response) {
		try {
			param="1";
			model.addAttribute("libroForm",new LibroForm());
			request.setAttribute("param",param);
			allAutori=getServices().getAllAutori();
			allGeneri=getServices().getAllGeneri();
			//metodo che utilizzo per mostrare all'utente il nome dell'autore
			UtilMethod.settaDescrizioni(allAutori);
			request.setAttribute("allAutori", allAutori);
			request.setAttribute("allGeneri", allGeneri);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "indexInsert";
	}
	@RequestMapping(value="insertEnd",method=RequestMethod.POST)
	public String indexInsertEnd(@RequestParam CommonsMultipartFile fileUpload,@ModelAttribute("libroForm")LibroForm libroForm,BindingResult result, HttpServletRequest request,HttpServletResponse response) {
		boolean inserimento=false;
		String message=null;
		Libro libro=null;
		try {
			if(result!=null && result.hasErrors()) {
				request.setAttribute("messageError",getProperties().getProperty("errore.messaggio"));
				return "errore";
			}
			//controlliamo i campi
			libroFormValidator.setBean(libroForm);
			libroFormValidator.checkParameter();
			
			inserimento=libroFormValidator.isValido();
			if(inserimento) {
				libro=UtilMethod.convertiLibroForm(libroForm);
				if(libro!=null) {
					//UtilMethod.processaLibroForm(libroForm);
					String path="";
					inserimento=getServices().inserisciLibro(libro,fileUpload,libroForm);
					if(inserimento) {
						message=getProperties().getProperty("messaggio.inserimento.successo");
						//
					}else {
						message=getProperties().getProperty("messaggio.inserimento.errore");
					}
				}
			}
			if(!inserimento) {
				message=getProperties().getProperty("messaggio.inserimento.errore");
				request.setAttribute("messageError",message);
				return "errore";
			}
		}catch(Exception e) {
			e.printStackTrace();
			message=getProperties().getProperty("messaggio.inserimento.errore");
			request.setAttribute("messageError",message);
			return "errore";
		}
		request.setAttribute("messageSuccess",message);
		return "indexInsert";
	}
	
	/**AUTORE*/
	@RequestMapping(value="insertIndexAuth")
	public String indexInsertAuth(Model model,HttpServletRequest request,HttpServletResponse response) {
		try {
			model.addAttribute("autoreBean",new AutoreForm());
			this.param="1";
			request.setAttribute("param",param);
		}catch(Exception e) {
			
		}
		return "indexAuthInsert";
		
	}
	@RequestMapping(value="insertIndexEndAuth",method=RequestMethod.POST)
	public String indexInsertEndAuth(@ModelAttribute("autoreBean")AutoreForm autoreBean,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
		boolean inserito=false;
		try {
			if(result.hasErrors()) {
				request.setAttribute("messageError",getProperties().getProperty("errore.messaggio"));
				return "errore";
			}
			Autore auth=null;
			autoreFormValidator.setBean(autoreBean);
			autoreFormValidator.checkParameter();
			boolean valido=autoreFormValidator.isValido();
			if(valido) {
				auth=new Autore();
				auth.setNome(autoreBean.getNome());
				auth.setCognome(autoreBean.getCognome());
				inserito=getServices().inserisciAutore(auth);
			}else {
				request.setAttribute("messageError",getProperties().getProperty("errore.messaggio.nonValido"));
				return "errore";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		param="1";
		request.setAttribute("param",param);
		autoreBean.setNome(null);
		autoreBean.setCognome(null);
		return "indexAuthInsert";
	}
	
	public List<Autore> getAllAutori() {
		return allAutori;
	}

	public void setAllAutori(List<Autore> allAutori) {
		this.allAutori = allAutori;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Genere> getAllGeneri() {
		return allGeneri;
	}

	public void setAllGeneri(List<Genere> allGeneri) {
		this.allGeneri = allGeneri;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public Map<String, Object> getMappaEsiti() {
		return mappaEsiti;
	}

	public void setMappaEsiti(Map<String, Object> mappaEsiti) {
		this.mappaEsiti = mappaEsiti;
	}

	

	public AutoreFormValidator getAutoreFormValidator() {
		return autoreFormValidator;
	}

	public void setAutoreFormValidator(AutoreFormValidator autoreFormValidator) {
		this.autoreFormValidator = autoreFormValidator;
	}

	public LibroFormValidator getLibroFormValidator() {
		return libroFormValidator;
	}

	public void setLibroFormValidator(LibroFormValidator libroFormValidator) {
		this.libroFormValidator = libroFormValidator;
	}


	public Properties getProperties() {
		return properties;
	}


	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	


	
	
	

	
	
}
