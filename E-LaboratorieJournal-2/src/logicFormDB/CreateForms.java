package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DBConnection;
import logic.ChemReagentForm;
import logic.Student;

public class CreateForms {
	private DBConnection connection;

//	AnalyzeInformationDB ai = new AnalyzeInformationDB(connection);
//	FormInformationDB fi = new FormInformationDB(connection);

	public CreateForms(DBConnection connection) {
		this.connection = connection;
	}

	public boolean addChemReagent(ChemReagentForm chemReagentForm, Student student) {
		AnalyzeInformationDB ai = new AnalyzeInformationDB(connection);
		FormInformationDB fi = new FormInformationDB(connection);
		ai.addAnalyzeInfo(chemReagentForm);
		System.out.println("AnalyzeInf");
		fi.addFormInformation(chemReagentForm, student);
		System.out.println("FormInformation");
		ai.addStudentForm(student, chemReagentForm);
		System.out.println("StudentForm");

		String sql = "INSERT INTO reagent_Chem (" + "analyzeID," + "volume," + "accConcentration,"
				+ "lifeTimeF," + "storage," + "batchNo," + "lotNo," + "supplier" + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			PreparedStatement add = connection.getConnection().prepareStatement(sql);
			
			add.setInt(1, chemReagentForm.getAnalyzeID());
			add.setString(2, chemReagentForm.getVolume());
			add.setString(3, chemReagentForm.getConcentration());
			add.setString(4, chemReagentForm.getlifeTimeF());
			add.setString(5, chemReagentForm.getStorage());
			add.setString(6, chemReagentForm.getBatchNo());
			add.setString(7, chemReagentForm.getLotNo());
			add.setString(8, chemReagentForm.getSupplier());
			
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
