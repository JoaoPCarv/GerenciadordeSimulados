package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.checker.Checker;
import br.com.JoaoPCarv.GerenciadordeSimulados.enums.ModelsEnum;
import br.com.JoaoPCarv.GerenciadordeSimulados.enums.UserStatusEnum;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.ExistingUserException;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongArgumentException;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;
import br.com.JoaoPCarv.GerenciadordeSimulados.model.Administrador;

public abstract class RecordableFactory {

	public static Recordable getRecordable(String[] params) throws ExistingUserException, WrongArgumentException {

		if (Checker.checkLogin(params) && params[1].equals(UserStatusEnum.NEW.getName()))
			throw new ExistingUserException();
		
		else if(Checker.checkLogin(params) && params[1].equals(UserStatusEnum.EXISTING.getName()) &&
				!Checker.checkPassword(params)) 
			throw new WrongArgumentException("Senha errada.");

		else {

			switch (params[0]) {

			case "Administrador":

				if(params[1].equals(UserStatusEnum.NEW.getName())) {
					
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

			return null;

		}
	}

	public static Recordable getRecordable(String type, int ID) {

		switch (type) {

		case "Administrador":

			try {
				return new Administrador(ID);
			} catch (WrongArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}

		}

		return null;
	}

}
