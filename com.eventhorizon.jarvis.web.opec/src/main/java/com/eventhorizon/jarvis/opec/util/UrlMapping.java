package com.eventhorizon.jarvis.opec.util;


/**
 * Classe que contém todos os mapeamentos do OPEC
 * 
 * 
 * 
 * @author iuriandreazza
 */
public class UrlMapping {
	
	//HOME
	public final static String ROOT_FULL_URL  = "/";
	public final static String ROOT_URL  = "/app/";
	public final static String HOME_URL  = "/app/home";
	
	//LOGIN - SECURITY
	public final static String LOGIN_URL  = "/login";
	public final static String LOGIN_AUTH_URL = "/login/auth";
	public final static String LOGIN_ERROR_URL  = "/login/error/{code}";
	public final static String LOGIN_ACCESS_DENIED_URL  = "/login/access/denied";
	public final static String LOGOUT  = "/logout";



    //CRUD Urls
    public final static String LIST_URL = "/List";
    public final static String EDIT_URL = "/Edit/{id}";
    public final static String DELETE_URL = "/Delete/{id}";
	
	
	
}
