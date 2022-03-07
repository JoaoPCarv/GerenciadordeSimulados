package br.com.JoaoPCarv.GerenciadordeSimulados.main;

import java.util.List;

import br.com.JoaoPCarv.GerenciadordeSimulados.daos.AdministradorDAO;
import br.com.JoaoPCarv.GerenciadordeSimulados.factories.IDFactory;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;
import br.com.JoaoPCarv.GerenciadordeSimulados.model.Administrador;

public class Initializer {

	public static void main(String[] args) {

		try {
			String path = "C:\\Users\\Administrador.000\\.eclipse\\GerenciadorDeSimulados"
					+ "\\src\\br\\com\\JoaoPCarv\\GerenciadordeSimulados\\admins\\"
					+ "ADM";
			
			Administrador obj1 = new Administrador("Pedro", IDFactory.generateID(path), "abcd1234");
			obj1.recordThisOnTxt();
			Administrador obj2 = new Administrador("Leo", IDFactory.generateID(path), "1234qwer");
			obj2.recordThisOnTxt();
			Administrador obj3 = new Administrador("SysOut", IDFactory.generateID(path), "qwertyui");
			obj3.recordThisOnTxt();
			
			AdministradorDAO daoObject = new AdministradorDAO();
			
			daoObject.insert(obj1);
			daoObject.insert(obj2);
			daoObject.insert(obj3);


			
			List<Recordable> lista = new AdministradorDAO().selectAll();
			
			for(Recordable adm: lista) {
				
				Administrador a = (Administrador) adm;
				a.show();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
