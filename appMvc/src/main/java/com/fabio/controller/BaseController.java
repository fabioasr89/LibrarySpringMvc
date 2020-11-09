	package com.fabio.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.fabio.services.Services;
import com.google.gson.Gson;

/**
 * 
 * 
 * @author FABIO PETRICOLA
 *
 */
public  class BaseController {
	@Autowired
	private Services services;
	@Autowired
	private Properties properties;
	@Autowired
	private Gson json;
	
	
	public BaseController() {
		
	}
	
	
	
	public Properties getProperties() {
		return properties;
	}



	public void setProperties(Properties properties) {
		this.properties = properties;
	}



	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}



	public Gson getJson() {
		return json;
	}



	public void setJson(Gson json) {
		this.json = json;
	}

	

	
	
}
