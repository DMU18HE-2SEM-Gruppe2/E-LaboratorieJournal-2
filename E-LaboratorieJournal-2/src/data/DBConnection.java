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

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

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

			connection = DriverManager.getConnection(connectionString);

			return true;

		} catch (SQLException e) {
			System.out.println("Could not connect to Database");
			System.out.println(e.getMessage());

			return false;
		}
	}
}
