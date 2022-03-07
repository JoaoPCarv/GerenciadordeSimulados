package br.com.JoaoPCarv.GerenciadordeSimulados.exceptions;

@SuppressWarnings("serial")
public class InstantiableException extends Exception {
	
	private static final String message = "Erro na instanciação do objeto.";
	
	public InstantiableException() {
		
		super(message);
		
	}

}
