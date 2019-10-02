package br.com.univille.poo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
	
	private static CriarConexao instance;

	private static String banco = "1144002555";
	private static String usuario = "root";
	private static String senha = "root1234";
	
	private CriarConexao() {}

	public static CriarConexao getInstance() {
		if(instance == null) {
			instance = new CriarConexao();
		}
		return instance;
	}
	
	public Connection getConnection(){
		try {
		return DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/"+banco,usuario,senha);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
