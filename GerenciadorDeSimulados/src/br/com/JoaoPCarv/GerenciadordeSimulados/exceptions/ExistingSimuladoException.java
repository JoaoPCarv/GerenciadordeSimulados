package br.com.JoaoPCarv.GerenciadordeSimulados.exceptions;

@SuppressWarnings("serial")
public class ExistingSimuladoException extends Exception{
	
private static final String message = "Simulado j� existente.";
	
	public ExistingSimuladoException() {
		
		super(message);
		
	}

}
