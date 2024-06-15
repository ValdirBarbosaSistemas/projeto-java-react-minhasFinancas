package br.com.springbootReact.exceptions;

import java.io.Serial;

public class ErroAutenticacaoException extends RuntimeException{

	@Serial
	private static final long serialVersionUID = 1L;

	public ErroAutenticacaoException(String mensagem) {
		super(mensagem);
	}
}
