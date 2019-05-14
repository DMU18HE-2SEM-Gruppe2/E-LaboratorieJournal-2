package presentation;

import java.time.LocalDate;

import data.DBConnection;
import logic.ChemReagentForm;
import logicFormDB.CreateForms;

public class Main {

	public static void main(String[] args) {
		DBConnection connection = new DBConnection();
		CreateForms cf = new CreateForms(connection.getConnection());
		
		ChemReagentForm crf = new ChemReagentForm(LocalDate.now(), "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
		
		
		
		cf.addForm1(crf);
		
		connection.getConnection();
		
		System.out.println("test");
	}
	

}
