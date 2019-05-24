package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.DBConnection;
import logic.ChemReagentForm;
import logic.Student;

public class AnalyzeInformationDB {

	DBConnection connection = new DBConnection();

	public boolean addAnalyzeInfo(ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement add = connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			System.out.println(sql);
			
			
			add.setLong(1, chemReagentForm.getDate().toEpochDay());
			add.setString(2, chemReagentForm.getThemeName());
			add.setString(3, chemReagentForm.getAnalyzeTitle());
			add.setString(4, chemReagentForm.getComments());
			
			System.out.println(sql);
			int nRows = add.executeUpdate();
			
			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						chemReagentForm.setAnalyzeID(add.getGeneratedKeys().getInt(1));
						System.out.println(chemReagentForm);
						return true;
					}
				}
			}
		return true;
	
	} catch (SQLException e) {
		System.out.println("Failed to add: " + chemReagentForm);
		System.out.println(e.getMessage());
		return false;
	}
}
	public boolean addStudentForm(Student student, ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO student_analyzeInformation (" + "studentID," + "analyzeID) VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, student.getStudentID());
			add.setInt(2, chemReagentForm.getAnalyzeID());

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