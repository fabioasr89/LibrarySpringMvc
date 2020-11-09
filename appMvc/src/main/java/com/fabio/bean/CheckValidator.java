package com.fabio.bean;
/**
 * 
 * @author Fabio Petricola
 *
 */
/**
 * Usiamo questa classe astratta per gestire i controlli sulle espressioni regolari. Potremmo anche ampliarla e inserire
 * altri controlli, ad esempio sul formato dei caratteri...
 * */
public abstract class CheckValidator {
	//Usiamo questa espressione regolare per controllare che i dati in formato testo arrivino effettivamente cosi
	private static final String regexTesto="[a-zA-Z]";
	public CheckValidator() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void checkParameter();

	public static String getRegexTesto() {
		return regexTesto;
	}
	
}
