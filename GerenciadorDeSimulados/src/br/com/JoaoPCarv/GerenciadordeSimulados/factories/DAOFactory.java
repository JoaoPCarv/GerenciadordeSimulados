package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import br.com.JoaoPCarv.GerenciadordeSimulados.daos.AdministradorDAO;
import br.com.JoaoPCarv.GerenciadordeSimulados.enums.ModelsEnum;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.DAO;

public abstract class DAOFactory {
	
	public static DAO getDAO(String[] params) {
		
		if(params[0].equals(ModelsEnum.ADMIN.getName())) return new AdministradorDAO();
		else if(params[0].equals(ModelsEnum.STUDENT.getName())) return null;
		
		return null;
	}
	

}
