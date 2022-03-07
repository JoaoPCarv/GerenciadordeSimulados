// Os caminhos aqui utilizados s�o nativos. Configurar para a m�quina local durante a implementa��o.

package br.com.JoaoPCarv.GerenciadordeSimulados.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongArgumentException;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;

public class Administrador implements Recordable {
	
	private String adm_login;
	private int adm_ID;
	private String adm_senha;
	
	public String getAdm_login() {
		return this.adm_login;
	}
	public void setAdm_login(String adm_login) {
		this.adm_login = adm_login;
	}
	public int getAdm_ID() {
		return this.adm_ID;
	}
	public void setAdm_ID(int adm_ID) {
		this.adm_ID = adm_ID;
	}
	public String getAdm_senha() {
		return this.adm_senha;
	}
	public void setAdm_senha(String adm_senha) {
		this.adm_senha = adm_senha;
	}
	
	public String getPath() {
		
		return "C:\\Users\\Administrador.000\\.eclipse\\GerenciadorDeSimulados"
				+ "\\src\\br\\com\\JoaoPCarv\\GerenciadordeSimulados\\admins\\"
				+ "ADM" + Integer.toString(this.getAdm_ID()) + ".txt";
	}
	
	@Override
	public boolean recordThisOnTxt() {
	
		String path = this.getPath();
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
			
			writer.write(this.getAdm_login() + "\n");
			writer.write(Integer.toString(this.getAdm_ID()) + "\n");
			writer.write(this.getAdm_senha());
			writer.close();
			
			return true;
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return false;
	}
	
	public Administrador(String adm_login, int adm_ID, String adm_senha) throws WrongArgumentException{
		
		String message = "";
		boolean error = adm_login.length() == 0 || adm_ID < 0 || adm_senha.length() != 8;
		
		if(adm_login.length() == 0) {
			message += "O login n�o pode ser nulo. \n ";
		}
		if(adm_ID < 0) {
			message += "O ID de administrador n�o pode ser negativo. \n";
		}
		if(adm_senha.length() != 8) {
			message += "A senha deve conter 8 caracteres.";
		}
		
		if(error) {
			throw new WrongArgumentException(message);
		}
		
		this.setAdm_login(adm_login);
		this.setAdm_ID(adm_ID);
		this.setAdm_senha(adm_senha);
		
	}
	
	public Administrador(int adm_ID)  throws WrongArgumentException{
		
		if(adm_ID < 0) {
			
			throw new WrongArgumentException("O ID de administrador n�o pode ser negativo.");
		}
		this.setAdm_ID(adm_ID);
		String path = this.getPath();
				
		File file = new File(path);
		
		if(!file.exists()) {
			
			throw new WrongArgumentException("N�o existe administrador com ID " + adm_ID + ".");
		}
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			this.setAdm_login(reader.readLine());
			this.setAdm_ID(Integer.parseInt(reader.readLine()));
			this.setAdm_senha(reader.readLine());
			
			reader.close();

		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	};
	
	public void show() {
		
		System.out.println("Login: " + this.getAdm_login() + "; ID: " + this.getAdm_ID() + "; senha: " + this.getAdm_senha());
		
	}
	

}
