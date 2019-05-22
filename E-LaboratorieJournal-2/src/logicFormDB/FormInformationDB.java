package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.DBConnection;
import logic.ChemReagentForm;
import logic.Student;

public class FormInformationDB {
	private DBConnection connection;

	public FormInformationDB(DBConnection connection) {
		this.connection = connection;
	}

	public boolean addFormInformation(ChemReagentForm chemReagentForm, Student student) {

		String sql = "INSERT INTO formInformation (" + "analyzeID," + "reagentName" + ") VALUES (?, ?)";
		System.out.println(sql);

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {

			add.setInt(1, chemReagentForm.getAnalyzeID());
			add.setString(2, chemReagentForm.getReagentName());

			int nRows = add.executeUpdate();

			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						chemReagentForm.setAnalyzeID(add.getGeneratedKeys().getInt(1));
						System.out.println(chemReagentForm);
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


}
