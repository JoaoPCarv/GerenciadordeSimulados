package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.checker.Checker;
import br.com.JoaoPCarv.GerenciadordeSimulados.enums.ModelsEnum;
import br.com.JoaoPCarv.GerenciadordeSimulados.enums.ObjectStatusEnum;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.ExistingSimuladoException;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.ExistingUserException;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongArgumentException;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;
import br.com.JoaoPCarv.GerenciadordeSimulados.model.Administrador;
import br.com.JoaoPCarv.GerenciadordeSimulados.model.Simulado;

public abstract class RecordableFactory {

	public static Recordable getRecordable(String[] params)
			throws ExistingUserException, WrongArgumentException, ExistingSimuladoException {

		boolean loginable = params[0].equals("Administrador") || params[0].equals("Estudante");

		if (loginable && Checker.checkLogin(params) && params[1].equals(ObjectStatusEnum.NEW.getName()))
			throw new ExistingUserException();

		if (loginable && Checker.checkLogin(params) && params[1].equals(ObjectStatusEnum.EXISTING.getName())
				&& !Checker.checkPassword(params))
			throw new WrongArgumentException("Senha errada.");

		if (loginable && !Checker.checkLogin(params) && params[1].equals(ObjectStatusEnum.EXISTING.getName()))
			throw new WrongArgumentException("Usuário não existente.");

		if (params[0].equals("Simulado") && Checker.checkName(params)
				&& params[1].equals(ObjectStatusEnum.NEW.getName()))
			throw new ExistingSimuladoException();

		if (params[0].equals("Simulado") && !Checker.checkName(params)
				&& params[1].equals(ObjectStatusEnum.EXISTING.getName()))
			throw new WrongArgumentException("Simulado não existente.");

		switch (params[0]) {

		case "Administrador": {

			if (params[1].equals(ObjectStatusEnum.NEW.getName())) {

				try {
					return new Administrador(params[2], IDFactory.generateID(params[3]), params[4]);
				} catch (WrongArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

			} else {

				int ID = IDFactory.recoverID(ModelsEnum.ADMIN.getPath(), params[2]);
				return new Administrador(ID);
			}
		}
		
		case "Estudante": {}
		
		case "Simulado": {
			
			if(params[1].equals(ObjectStatusEnum.NEW.getName())) {
				
				try {
					return new Simulado(params[2], IDFactory.generateID(params[3]), params[4], 
							Integer.parseInt(params[5]), Integer.parseInt(params[6]), null);
				} catch (WrongArgumentException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			} else {
				
				int ID = IDFactory.recoverID(ModelsEnum.SIMULADO.getPath(), params[2]);
				return new Simulado(ID);
				
			}
		}

		}

		return null;

	}

	public static Recordable getRecordable(String type, int ID) {

		switch (type) {

		case "Administrador":{
			
			try {
				return new Administrador(ID);
			} catch (WrongArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		
		case "Estudante":{}
		
		case "Simulado":{
			
			try {
				return new Simulado(ID);
			} catch (WrongArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}

		}

		return null;
	}

}
