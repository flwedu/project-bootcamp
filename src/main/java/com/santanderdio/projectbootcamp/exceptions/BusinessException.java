package com.santanderdio.projectbootcamp.exceptions;

/**
 * Esse objeto representa um erro de lógica de negócios que pode ser instanciado
 * via <b>throw new BusinessException</b> e que será capturado automaticamente
 * pelo {@link CustomExceptionsHandler}.
 * 
 * @author Eduardo
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}

}
