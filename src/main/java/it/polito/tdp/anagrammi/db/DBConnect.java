package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=root";

	public static Connection getConnection() {

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
}

// ...............................................................................

class TestDB {

	public static void main(String[] args) {
		/*
		 * This is a main to check the DB connection
		 */

		try {
			ParolaDAO vdao = new ParolaDAO();
			vdao.getTutteLeParole();
			System.out.println("TestDB passed");

		} catch (RuntimeException e) {
			System.err.println("TestDB failed");
		}
	}

}
