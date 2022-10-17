package br.com.merge.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnetionFactoy {

	private static Connection conexao;

	/**
	 * Obtem uma conexão com o banco de dados
	 * 
	 * @return Connection conexão com o banco de dados
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm94898", "191195");

		return conexao;
	}

}
