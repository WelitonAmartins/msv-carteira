package br.com.martins.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpUtils {

	/**
	 * Criar headers vazio de um request.
	 * @return HttpHeaders
	 */
	public static HttpHeaders criarHeader() {   
	    HttpHeaders headers = new HttpHeaders();
	    return headers;
	}
	
	/**
	 * Criar headers de um request com header
	 * APPLICATION_JSON.
	 * @return HttpHeaders
	 */
	public static HttpHeaders criarJsonHeader() {   
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	    return headers;
	}
}
