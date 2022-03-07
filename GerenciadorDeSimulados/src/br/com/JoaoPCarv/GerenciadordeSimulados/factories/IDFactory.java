package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import java.io.File;

public abstract class IDFactory {
	
	public static int generateID(String path) {
		
		int ID = 1;
		
		String full_path = path + ID + ".txt";
		
		while(new File(full_path).exists()) {
			
			ID++;
			full_path = path + ID + ".txt";
		}
		
		return ID;}

}
