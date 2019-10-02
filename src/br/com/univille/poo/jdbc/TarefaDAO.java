package br.com.univille.poo.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BasicoDAO{

	public void insert(Tarefa tarefa) {

		String sql = " insert into tarefa(NUMERO, ESTADO, DATA_ABERTURA, ID_RESPONSAVEL, TITULO) " +
				"values(?,?,?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(1, tarefa.getNumero());
			statement.setLong(2, tarefa.getEstado());
			statement.setDate(3, (Date) tarefa.getData_abertura());
			statement.setLong(3, tarefa.getId_responsavel());
			statement.setString(3, tarefa.getTitulo());
			
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Tarefa tarefa) {
		
		String sql = "delete from tarefa where numero = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, tarefa.getNumero());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Tarefa tarefa) {
		String sql = "update tarefa set responsavel = ?, titulo = ?, descricao = ? where numero = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setLong(1, tarefa.getId_responsavel());
			statement.setString(2, tarefa.getTitulo());
			statement.setString(3, tarefa.getDescricao());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Tarefa getPorId(int id) {
		Tarefa tarefa = null;
		String sql = " select numero, estado, data_abertura, id_responsavel, titulo, descricao from tarefa where numero = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				tarefa = new Tarefa();
				tarefa.setNumero(resultSet.getInt(1));
				tarefa.setEstado(resultSet.getInt(2));
				tarefa.setData_abertura(resultSet.getDate(3));
				tarefa.setId_responsavel(resultSet.getInt(4));
				tarefa.setTitulo(resultSet.getString(5));
				tarefa.setDescricao(resultSet.getString(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tarefa;
	}
	
}
