//Interface para objetos que devem ser gravados em arquivo ".txt"

package br.com.JoaoPCarv.GerenciadordeSimulados.interfaces;

public interface Recordable {
	
	public boolean recordThisOnTxt();
	
	public String getPath();
	
	public void show();

}
