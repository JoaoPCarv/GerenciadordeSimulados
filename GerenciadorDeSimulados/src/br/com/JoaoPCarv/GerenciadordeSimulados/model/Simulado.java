package br.com.JoaoPCarv.GerenciadordeSimulados.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.enums.ModelsEnum;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongArgumentException;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongFilePathException;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;

public class Simulado implements Recordable {

	private String sim_nome;
	private int sim_id;
	private String sim_tipo;
	private int sim_ano;
	private int sim_num_questoes;
	private ArrayList<String> sim_gabarito;

	public String getSim_nome() {
		return this.sim_nome;
	}

	private void setSim_nome(String sim_nome) {
		this.sim_nome = sim_nome;
	}

	public int getSim_id() {
		return this.sim_id;
	}

	private void setSim_id(int sim_id) {
		this.sim_id = sim_id;
	}

	public String getSim_tipo() {
		return this.sim_tipo;
	}

	private void setSim_tipo(String sim_tipo) {
		this.sim_tipo = sim_tipo;
	}

	public int getSim_ano() {
		return this.sim_ano;
	}

	private void setSim_ano(int sim_ano) {
		this.sim_ano = sim_ano;
	}

	public int getSim_num_questoes() {
		return this.sim_num_questoes;
	}

	private void setSim_num_questoes(int sim_num_questoes) {
		this.sim_num_questoes = sim_num_questoes;
	}

	public ArrayList<String> getSim_gabarito() {
		return this.sim_gabarito;
	}

	private void setSim_gabarito(ArrayList<String> sim_gabarito) {
		this.sim_gabarito = sim_gabarito;
	}

	public Simulado(String sim_nome, int sim_id, String sim_tipo, int sim_ano, int sim_num_questoes,
			ArrayList<String> sim_gabarito) throws WrongArgumentException {
		
		String message = "";
		boolean error = sim_nome.length() == 0 || sim_id <= 0 || sim_num_questoes <= 0;
		
		if(sim_nome.length() == 0) {
			message += "O nome do simulado não pode ser nulo. \n";
			
		}
		
		if(sim_id <= 0) {
			message += "O ID de simulado deve ser positivo. \n";
		}
		
		if(sim_num_questoes <= 0) {
			message += "O número de questões deve ser positivo.";
		}
		
		if(error) {
			throw new WrongArgumentException(message);
		}
		
		this.setSim_nome(sim_nome);
		this.setSim_id(sim_id);
		this.setSim_tipo(sim_tipo);
		this.setSim_ano(sim_ano);
		this.setSim_num_questoes(sim_num_questoes);
		this.setSim_gabarito(sim_gabarito);

	}

	public Simulado(int sim_ID) throws WrongArgumentException {

		if (sim_ID < 0) {

			throw new WrongArgumentException("O ID de simulado não pode ser negativo.");
		}

		this.setSim_id(sim_ID);
		String path = this.getPath();

		File file = new File(path);

		if (!file.exists()) {

			throw new WrongArgumentException("Não existe simulado com ID " + sim_ID + ".");
		}

		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			this.setSim_nome(reader.readLine());
			this.setSim_id(Integer.parseInt(reader.readLine()));
			this.setSim_tipo(reader.readLine());
			this.setSim_ano(Integer.parseInt(reader.readLine()));
			this.setSim_num_questoes(Integer.parseInt(reader.readLine()));
			
			List<String> lista = new ArrayList<>();
			
			for(int i = 0; i < this.getSim_num_questoes(); i++) {
				
				lista.add(reader.readLine());
				
			}
			
			this.setSim_gabarito((ArrayList<String>) lista);
			
			reader.close();
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	@Override
	public String getPath() {
		return ModelsEnum.SIMULADO.getPath() + Integer.toString(this.getSim_id()) + ".txt";
	}

	@Override
	public boolean recordThisOnTxt() {

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.getPath())));

			writer.write(this.getSim_nome() + "\n");
			writer.write(Integer.toString(this.getSim_id()) + "\n");
			writer.write(this.getSim_tipo() + "\n");
			writer.write(this.getSim_ano() + "\n");
			writer.write(Integer.toString(this.getSim_num_questoes()) + "\n");

			for (int i = 0; i < this.getSim_num_questoes(); i++) {

				writer.write(this.getSim_gabarito().get(i) + "\n");
			}

			writer.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}
		return false;
	}

	@Override
	public void show() {
		
		System.out.println("OBJETO CRIADO. NOME: " + this.getSim_nome() + "; ID:" + this.getSim_id());

	}

	public boolean lerGabarito(String gab_path) {

		try {

			File file = new File(gab_path);

			if (!file.exists())
				throw new WrongFilePathException();
			else {

				BufferedReader reader = new BufferedReader(new FileReader(file));

				List<String> gabarito = new ArrayList<>();

				for (int i = 0; i < this.getSim_num_questoes(); i++) {

					gabarito.add(reader.readLine());

				}

				this.setSim_gabarito((ArrayList<String>) gabarito);
				reader.close();
				return true;
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return false;
	}

}
