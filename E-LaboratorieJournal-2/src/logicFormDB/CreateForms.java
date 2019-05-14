package logicFormDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logic.ChemReagentForm;

public class CreateForms {
	private Connection connection;

	AnalyzeInformationDB ai = new AnalyzeInformationDB(connection);
	FormInformationDB fi = new FormInformationDB(connection);

	public CreateForms(Connection connection) {
		this.connection = connection;
	}

	public boolean addForm1(ChemReagentForm chemReagentForm) {
		
		ai.addAnalyzeInfo(chemReagentForm);
		fi.addFormInformation(chemReagentForm);

		String sql = "INSERT INTO form1 (" + "volume," + "accConcentraion," + "lifeTimeF,"
				+ "storage) VALUSE (?, ?, ?, ?)";
		System.out.println(sql);

		try {
			PreparedStatement add = connection.prepareStatement(sql);
			add.setString(1, chemReagentForm.getVolume());
			add.setString(2, chemReagentForm.getConcentration());
			add.setString(3, chemReagentForm.getShellLife());
			add.setString(4, chemReagentForm.getStorage());
			
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
