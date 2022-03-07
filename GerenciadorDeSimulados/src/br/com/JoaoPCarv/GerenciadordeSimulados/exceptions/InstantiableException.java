package br.com.JoaoPCarv.GerenciadordeSimulados.exceptions;

@SuppressWarnings("serial")
public class InstantiableException extends Exception {
	
	private static final String message = "Erro na instancia��o do objeto.";
	
	public InstantiableException() {
		
		super(message);
		
	}

}
