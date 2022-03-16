package br.com.JoaoPCarv.GerenciadordeSimulados.enums;

public enum ObjectStatusEnum {
	
	NEW, EXISTING;
	
	public String getName() {
		
		switch(this) {
		
		case NEW: return "new";
		case EXISTING: return "existing";
		
		}
		
		return null;
	}

}
