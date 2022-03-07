package br.com.JoaoPCarv.GerenciadordeSimulados.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class ConnectionFactory {

	public static Connection getConnection() throws SQLException {

		Connection con = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
					+ "username=Joao;password=senha;databaseName=GerenciadordeSimulados;encrypt=false");

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return con;

	}

}
