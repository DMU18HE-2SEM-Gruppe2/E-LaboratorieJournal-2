package logic;

import java.time.LocalDate;

import data.DBConnection;
import data.DBOthers;
import logicFormDB.AnalyzeInformationDB;
import logicFormDB.CreateForms;
import logicFormDB.FormInformationDB;

public class Main {

	public static void main(String[] args) {
//		BioReagentForm BRFTest = new BioReagentForm(LocalDate.now(), "1", "1", "1", "1", "0", "0", "1", "1", "1", "1", "1",
//				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
//		System.out.println(BRFTest);
		DBConnection connection = new DBConnection();
		DBOthers DBO = new DBOthers();
		AnalyzeInformationDB aiDB = new AnalyzeInformationDB(connection);
		FormInformationDB fiDB = new FormInformationDB(connection);
		CreateForms cfDB = new CreateForms(connection);
		
		Student std = new Student("Fornavn", "Efternavn", 0, 0);
		
		Course crs = new Course("DMU", 1);
		
		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Test2", "Brun Sæbe test2", "", 0, 0, "Grisefedttest2", "1",
				"12ab3", "GH Kemi", "Køleskab", "sæbe test 2 ", "vægt med udluft nr. 5", "500mL", "40%", "5 dage");
		
		ChemReagentForm crfTest2 = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", 0, 0, "Grisefedt", "1",
				"12ab3", "GH Kemi", "Køleskab", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%", "2 dage");
		
		DBO.addStudent(std, crs);
		cfDB.addChemReagent(crfTest, std);
//		aiDB.addAnalyzeInfo(crfTest);
//		System.out.println(std);
//		fiDB.addFormInformation(crfTest, std);
//		System.out.println(std);
//		aiDB.addStudentForm(std, crfTest);
//		System.out.println(std);
		
//		System.out.println(crfTest.toString());

	}

}
