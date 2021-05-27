package com.santanderdio.projectbootcamp.exceptions;

import com.santanderdio.projectbootcamp.util.MessageUtils;

/**
 * Um tipo de excessão lançado apenas em casos específicos. Como possui apenas
 * uma mensagem possível, a mesma é declarada na própria classe.
 */
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(MessageUtils.NO_RECORDS_FOUND);
	}

	public String getMessage() {
		return MessageUtils.NO_RECORDS_FOUND;
	}

}
