package br.com.JoaoPCarv.GerenciadordeSimulados.exceptions;

@SuppressWarnings("serial")
public class WrongFilePathException extends Exception {
	
	private static final String message = "O caminho referenciado está errado.";
	
	public WrongFilePathException() {
		
		super(message);
	}


}
