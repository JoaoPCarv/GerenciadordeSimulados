package br.com.JoaoPCarv.GerenciadordeSimulados.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.InstantiableException;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongArgumentException;
import br.com.JoaoPCarv.GerenciadordeSimulados.factories.ConnectionFactory;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.DAO;
import br.com.JoaoPCarv.GerenciadordeSimulados.interfaces.Recordable;
import br.com.JoaoPCarv.GerenciadordeSimulados.model.Administrador;

public class AdministradorDAO implements DAO {

	@Override
	public boolean insert(Object o) throws InstantiableException {

		if (!o.getClass().getName().equals("br.com.JoaoPCarv.GerenciadordeSimulados.model.Administrador")) {

			throw new InstantiableException();
		}

		Administrador adm = (Administrador) o;

		boolean result = false;

		try {

			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement(
					"Insert into Administrador (adm_login, adm_ID, adm_senha, adm_path) values (?,?,?,?)");

			stmt.setString(1, adm.getAdm_login());
			stmt.setString(2, Integer.toString(adm.getAdm_ID()));
			stmt.setString(3, adm.getAdm_senha());
			stmt.setString(4, adm.getPath());

			result = stmt.execute();
			stmt.close();

			return result;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result;

	}

	@Override
	public boolean delete(Object o) throws InstantiableException {

		if (!o.getClass().getName().equals("br.com.JoaoPCarv.GerenciadordeSimulados.model.Administrador")) {

			throw new InstantiableException();
		}

		Administrador adm = (Administrador) o;

		boolean result = false;

		try {
			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("Delete from Administrador where adm_ID=?");
			stmt.setString(1, Integer.toString(adm.getAdm_ID()));
			result = stmt.execute();
			stmt.close();

			return result;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result;
	}

	@Override
	public Recordable selectFromID(int ID) throws WrongArgumentException {

		try {

			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("Select * from Administrador where adm_ID=?");
			stmt.setString(1, Integer.toString(ID));
			stmt.execute();

			ResultSet rs = stmt.getResultSet();

			if (rs.next()) {

				return new Administrador(rs.getString("adm_login"), Integer.parseInt(rs.getString("adm_ID")),
						rs.getString("adm_senha"));

			} else {

				throw new WrongArgumentException("Não existe administrador com ID " + ID + ".");
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return null;
	}

	@Override
	public List<Recordable> selectAll() {

		List<Recordable> lista = new ArrayList<>();

		try {

			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("Select * from Administrador;");
			stmt.execute();

			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {

				lista.add(new Administrador(Integer.parseInt(rs.getString("adm_ID"))));
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return lista;
	}

}
