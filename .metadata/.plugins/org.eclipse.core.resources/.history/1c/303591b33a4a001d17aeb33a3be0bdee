package br.com.merge.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnetionFactoy {
	
	private static Connection conexao;
	
	/**
	 * Obtem uma conexão com o banco de dados
	 * @return Connection conexão com o banco de dados
	 */
	//static -> não precisa do objeto para ser utilizado
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		if (conexao == null) {
			//Conectar com o banco de dados
			//Registrar o driver do banco que será utilizado
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Obter a conexão com o banco de dados
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl","rm94898","191195");
		}
		
		return conexao;
	}

}
