package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public abstract class IDFactory {
	
	public static int generateID(String path) {
		
		int ID = 1;
		
		String full_path = path + ID + ".txt";
		
		while(new File(full_path).exists()) {
			
			ID++;
			full_path = path + ID + ".txt";
		}
		
		return ID;}
	
	@SuppressWarnings("resource")
	public static int recoverID(String path, String arg) {
		
		int ID = 1;
		
		String full_path = path + ID + ".txt";
		
		try {
			while(!new BufferedReader(new FileReader(new File(full_path))).readLine().equals(arg)) {
				
				ID++;
				full_path = path + ID + ".txt";
				
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return ID;
		
	}

}
