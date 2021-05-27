package com.santanderdio.projectbootcamp.exceptions;

/**
 * Esse objeto é responsável por guardar o texto vindo da exception lançada e
 * repassá-lo para o body de uma {@link ResponseEntity}.
 * 
 * @author Eduardo
 *
 */
public class ExceptionResponse {

	private String message;

	public ExceptionResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
