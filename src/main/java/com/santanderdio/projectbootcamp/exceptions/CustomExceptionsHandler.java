package com.santanderdio.projectbootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Essa classe é responsável por tratar as excessões, assim que são lançadas
 * pela JRE, e retornar uma {@code ResponseEntity}.
 * <p>
 * -> O método {@code handleSecurity} é disparado assim que uma excessão do tipo
 * {@link BusinessException} é detectada.
 * <p>
 * -> Após isso, é criada uma {@link ResponseEntity} com o código <i>422
 * Unprocessable Entity</i> no header.
 * <p>
 * -> No body dessa resposta vai a mensagem, dentro de um objeto
 * {@link ExceptionResponse}. Essa mensagem foi passada pela excessão lançada
 * via <b>throw new BusinessException(mensagem)</b>
 * <p>
 * -> O objeto {@link ResponseEntity} é retornado como resposta.
 */
@ControllerAdvice
public class CustomExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ExceptionResponse> handleSecurity(BusinessException e) {

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
	}

	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<ExceptionResponse> handleSecurity(NotFoundException e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}

}
