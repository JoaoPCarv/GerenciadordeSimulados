package br.com.JoaoPCarv.GerenciadordeSimulados.checker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.factories.ConnectionFactory;

public abstract class Checker {

	// Este método checa se o usuário já existe.
	public static boolean checkLogin(String[] params) {

		try {
			Connection con = ConnectionFactory.getConnection();

			String table = null;
			String column = null;

			switch (params[0]) {

			case "Administrador":

				table = "Administrador";
				column = "adm_login";
				break;

			case "Estudante":

				table = "Estudante";
				column = "stu_login";
				break;

			}

			String sql = "Select * from " + table + " where " + column + " = '" + params[2] + "'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();

			if (rs.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return false;
	}

	// Este método checa a senha passada pelo usuário.
	public static boolean checkPassword(String[] params) {

		try {
			Connection con = ConnectionFactory.getConnection();

			String password_type = null;
			String table = null;
			String column = null;
			String senha = null;

			switch (params[0]) {

			case "Administrador":

				password_type = "adm_senha";
				table = "Administrador";
				column = "adm_login";
				senha = params[4];
				break;

			case "Estudante":

				password_type = "stu_senha";
				table = "Estudante";
				column = "stu_login";
				break;

			}

			String sql = "Select " + password_type + " from " + table + " where " + column + " = '" + params[2] + "'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			rs.next();

			if (rs.getString("adm_senha").equals(senha))
				return true;
			else
				return false;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return false;

	}

	// Este método checa se o nome (de simulados, etc) é repetido.
	public static boolean checkName(String[] params) {

		try {
			Connection con = ConnectionFactory.getConnection();
						
			String table = null;
			String column = null;
			
			switch(params[0]) {
			
			case "Simulado":
				
				table = "Simulado";
				column = "sim_nome";
				
			
			}
			
			String sql = "Select * from " + table + " where " + column + " = '" + params[2] + "'";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			
			if (rs.next())
				return true;
			else
				return false;
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return false;
	}

}
