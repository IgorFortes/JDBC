package br.com.univille.poo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends BasicoDAO{

	public void insert(Pessoa pessoa) {

		String sql = " insert into pessoa(id, nome, sobrenome) values(?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(1, pessoa.getId());
			statement.setString(2, pessoa.getNome());
			statement.setString(3, pessoa.getFuncao());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Pessoa pessoa) {
		
		String sql = "delete from pessoa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, pessoa.getId());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Pessoa pessoa) {
		String sql = "update pessoa set nome = ?, funcao = ? where id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(1, pessoa.getId());
			statement.setString(2, pessoa.getNome());
			statement.setString(3, pessoa.getFuncao());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pessoa getPorId(int id) {
		Pessoa pessoa = null;
		String sql = " select id, nome, funcao from pessoa where id = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setFuncao(resultSet.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}
	
}
