package logicFormDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logic.ChemReagentForm;

public class AnalyzeInformationDB {

	private Connection connection;

	public AnalyzeInformationDB(Connection connection) {
		this.connection = connection;
	}

	public boolean addAnalyzeInfo(ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment) VALUES (?, ?, ?, ?)";
		
		try {
			System.out.println(sql);
			PreparedStatement add = connection.prepareStatement(sql);
			
			add.setLong(1, chemReagentForm.getDate().toEpochDay());
			add.setString(2, chemReagentForm.getThemeName());
			add.setString(3, chemReagentForm.getAnalyzeTitle());
			add.setString(4, chemReagentForm.getComments());
			
			System.out.println(sql);
			int nRows = add.executeUpdate();
			
			if (nRows != 1) {
				return false;
			}
		return true;
	
	} catch (SQLException e) {
		System.out.println("Failed to add: " + chemReagentForm);
		System.out.println(e.getMessage());
		return false;
	}
}
}