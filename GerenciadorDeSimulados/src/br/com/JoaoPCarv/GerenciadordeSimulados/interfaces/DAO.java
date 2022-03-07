package br.com.JoaoPCarv.GerenciadordeSimulados.interfaces;

import java.util.List;

import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.InstantiableException;
import br.com.JoaoPCarv.GerenciadordeSimulados.exceptions.WrongArgumentException;

public interface DAO {
	
	public boolean insert(Object o) throws InstantiableException;
	public boolean delete(Object o) throws InstantiableException;
	public Recordable selectFromID(int ID) throws WrongArgumentException;
	public List<Recordable> selectAll();

}
