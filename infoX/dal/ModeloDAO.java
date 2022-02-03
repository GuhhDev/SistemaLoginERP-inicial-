package br.com.infoX.dal;

import java.sql.*;

public class ModeloDAO {

	// Método conecta banco
	public static Connection conector() {
		Connection conexao = null;
		// Linha abaixo chama o driver
		String driver = "com.mysql.cj.jdbc.Driver";
		// Armazena informações referente ao banco
		String url = "jdbc:mysql://localhost:3306/dbinfox?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "admin";
		// Estabelece conexão com o banco
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
