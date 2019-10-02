package br.com.univille.poo.jdbc;

import java.sql.Connection;

public abstract class BasicoDAO {
	
	public Connection getConnection() {
		return CriarConexao.getInstance().getConnection();
	}

}
