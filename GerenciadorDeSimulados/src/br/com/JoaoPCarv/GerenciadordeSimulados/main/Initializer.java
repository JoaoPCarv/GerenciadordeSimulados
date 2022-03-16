package br.com.JoaoPCarv.GerenciadordeSimulados.main;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.factories.ParamListFactory;
import br.com.JoaoPCarv.GerenciadordeSimulados.factories.RecordableFactory;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;

public class Initializer {

	public static void main(String[] args) {

		try {
			
			String[] params = ParamListFactory.getParamList("Simulado", "new", "Fuvestão 2022", "FUVEST", "2022", "90");
			
			Recordable rec = RecordableFactory.getRecordable(params);
			
			rec.show();
						
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
