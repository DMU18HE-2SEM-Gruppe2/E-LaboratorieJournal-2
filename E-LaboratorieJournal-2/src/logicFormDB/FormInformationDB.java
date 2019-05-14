package logicFormDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logic.ChemReagentForm;

public class FormInformationDB {
	private Connection connection;

	public FormInformationDB(Connection conncetion) {
		this.connection = connection;
	}

	public boolean addFormInformation(ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO formInformation (" + "reagentName," + "batchNo," + "lotNo,"
				+ "supplier) VALUSE (?, ?, ?, ?)";
		System.out.println(sql);
		
		try {
			PreparedStatement add = connection.prepareStatement(sql);
			add.setString(1, chemReagentForm.getReagentName());
			add.setString(2, chemReagentForm.getBatchNo());
			add.setString(3, chemReagentForm.getLotNo());
			add.setString(4, chemReagentForm.getSupplier());
			
			int nRows = add.executeUpdate();
			
			if (nRows != 1) {
				return false;
			}
			return true;
		
	
	
	}catch(SQLException e) {
		System.out.println("Failed to add: " + chemReagentForm);
		System.out.println(e.getMessage());
		return false;
	}
}
}
