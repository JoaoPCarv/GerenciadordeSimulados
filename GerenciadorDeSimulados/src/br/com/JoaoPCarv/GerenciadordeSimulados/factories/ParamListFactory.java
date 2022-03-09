package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import br.com.JoaoPCarv.GerenciadordeSimulados.enums.ModelsEnum;

public abstract class ParamListFactory {
	
	public static String[] getParamList(String type, String arg1, String arg2, String arg3, String arg4) {
		
		
		switch(type) {
		
		case "Administrador":
			
			//Inclui o modelo de usuário e o status.
			String[] params = new String[ModelsEnum.ADMIN.getParamNumber() + 2];
			
			/*Regra de criação: 
			 * params[0] = Modelo-> administrador;
			 * params[1] = Status (new, existing);
			 * params[2] = adm_login;
			 * params[3] = Caminho (/ADM(+ID).txt);
			 * params[4] = Senha.
			 * */
			params[0] = ModelsEnum.ADMIN.getName();
			params[1] = arg1;
			params[2] = arg2;
			params[3] = ModelsEnum.ADMIN.getPath();
			params[4] = arg3;
			
			return params;
		
		}
		
		
		return null;
	}

}
