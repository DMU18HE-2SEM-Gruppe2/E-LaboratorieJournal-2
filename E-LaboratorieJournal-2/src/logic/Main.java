package logic;

import java.time.LocalDate;

import data.DBConnection;
import data.DBOthers;
import logicFormDB.BioReagentDB;
import logicFormDB.BioSubstrateDB;
import logicFormDB.ChemReagentDB;

public class Main {

	public static void main(String[] args) {
//		BioReagentForm BRFTest = new BioReagentForm(LocalDate.now(), "1", "1", "1", "1", "0", "0", "1", "1", "1", "1", "1",
//				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
//		System.out.println(BRFTest);
		DBConnection connection = new DBConnection();
		DBOthers DBO = new DBOthers();

		Student std = new Student("Fornavn", "Efternavn", 0, 0);

		Course crs = new Course("DMU", 1);

		// -----------------CHEM REAGENT CREATE TEST-----------------

		ChemReagentDB cfDB = new ChemReagentDB(connection);
//		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Test2", "Brun Sæbe test2", "", 0, 0,
//				"Grisefedttest2", "1", "12ab3", "GH Kemi", "Køleskab", "sæbe test 2 ", "vægt med udluft nr. 5", "500mL",
//				"40%");
//
//		ChemReagentForm crfTest2 = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", 0, 0, "Grisefedt",
//				"1", "12ab3", "GH Kemi", "Køleskab", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%");
//		
//		ChemReagentForm crfT = new ChemReagentForm(LocalDate.now(), "ThemeName", "AnalyzeTitel", "Comment", 0, 0,
//				"scaleNo", "Volume", "Concentration", "LifeTimeF", "Storage", "ReagentName", "BatchNo", "LotNo",
//				"Supplier");
////		
////
////		
////		
//		DBO.addStudent(std, crs);
//		cfDB.addChemReagent(crfT, std);

		// -----------------BIO REAGENT CREATE TEST-----------------

		BioReagentDB brDB = new BioReagentDB(connection);

		BioReagentForm brf = new BioReagentForm(LocalDate.now(), "1", "1", "1", 0, 0, "1", "1", "1", "1", "1", "1", "1",
				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
		DBO.addStudent(std, crs);
		brDB.addBioReagent(brf, std);

		// -----------------BIO SUBSTRATE CREATE TEST-----------------

		BioSubstrateDB bsDB = new BioSubstrateDB(connection);

		BioSubstrateForm bsf = new BioSubstrateForm(LocalDate.now(), "2", "2", "2", 0, 0, "2", "2", "2", "2", 0, "2",
				"2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", false, "2", "2", "2");

		DBO.addStudent(std, crs);
		bsDB.addBioSubstrate(bsf, std);

		// -----------------CHEM REAGENT READ TEST-----------------
//		ChemReagentContainer crc = new ChemReagentContainer();
//		
//		ChemReagentForm crfT = new ChemReagentForm(LocalDate.now(), "ThemeName", "AnalyzeTitel", "Comment", 0, 0,
//				"scaleNo", "Volume", "Concentration", "LifeTimeF", "Storage", "ReagentName", "BatchNo", "LotNo",
//				"Supplier");
//		ChemReagentForm crfT2 = new ChemReagentForm(LocalDate.now(), "ThemeName1", "AnalyzeTitel1", "Comment1", 0, 0,
//				"scaleNo1", "Volume1", "Concentration1", "LifeTimeF1", "Storage1", "ReagentName1", "BatchNo1", "LotNo1",
//				"Supplie1r");
//		DBO.addStudent(std, crs);
//		cfDB.addChemReagent(crfT2, std);
//		
//	
//		cfDB.getAllProducts(crc);
//		for(int i = 0; i < crc.getSize(); i++) {
//			System.out.println(crc.getElement(i));
//		}
//		System.out.println(crc.getSize());
//		for(int i = 0; i < crc.getSize(); i++) {
//			System.out.println(cfDB.getAllProducts());
//		}
		
	
	}

}
