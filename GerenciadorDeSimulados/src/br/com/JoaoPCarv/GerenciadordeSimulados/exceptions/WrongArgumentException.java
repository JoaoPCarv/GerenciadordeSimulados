package br.com.JoaoPCarv.GerenciadordeSimulados.exceptions;

@SuppressWarnings("serial")
public class WrongArgumentException extends Exception {
	
	private String message;
	
	public WrongArgumentException(String arg) {
	
		super(arg);
		this.message = arg;
		
	}
	
	@Override
	public String getMessage() {
		return this.message;
		
	}

}
