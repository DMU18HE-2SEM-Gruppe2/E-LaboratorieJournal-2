package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;

	public Connection getConnection() {
		if (!loadJDBCDriver()) {
			System.exit(1);
		}

		if (!openConnection("ELJ-DB")) {
			System.exit(2);
		}
		return connection;
	}

	// Loading the JDBC Driver
	private static boolean loadJDBCDriver() {
		try {
			System.out.println("Loading JDBC Driver...");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("JDBC Driver loaded");

			return true;

		} catch (ClassNotFoundException e) {
			System.out.println("Could not load JDBC Driver!");
			System.out.println(e.getMessage());
			return false;
		}
	}

	// Connection to the database
	private static boolean openConnection(String databaseName) {

		
		String instanceName = "SQLEXPRESS";
		String integratedSecurity = "true";

		String connectionString = "jdbc:sqlserver://localhost:1433;" + "instanceName=" + instanceName + ";"
				+ "databaseName=" + databaseName + ";" + "integratedSecurity=" + integratedSecurity + ";";

		connection = null;
		try {
			System.out.println("Connection to Database...");

			connection = DriverManager.getConnection(connectionString);

			System.out.println("Connected to Database");

			return true;

		} catch (SQLException e) {
			System.out.println("Could not connect to Database");
			System.out.println(e.getMessage());

			return false;
		}
	}
}
