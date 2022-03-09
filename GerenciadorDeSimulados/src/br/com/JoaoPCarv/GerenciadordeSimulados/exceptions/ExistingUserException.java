package br.com.JoaoPCarv.GerenciadordeSimulados.exceptions;

@SuppressWarnings("serial")
public class ExistingUserException extends Exception{
	
private static final String message = "Usuário já existente.";
	
	public ExistingUserException() {
		
		super(message);
		
	}

}
