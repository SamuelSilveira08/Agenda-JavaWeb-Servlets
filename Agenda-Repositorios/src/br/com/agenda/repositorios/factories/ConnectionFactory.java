package br.com.agenda.repositorios.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
		return connection;
	}

}
