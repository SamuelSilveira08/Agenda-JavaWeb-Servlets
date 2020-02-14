package br.com.agenda.repositorios.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?serverTimezone=UTC", "root", "root");
		return connection;
	}

}
