package logic;

import java.time.LocalDate;

import data.DBConnection;
import logicFormDB.BioReagentDB;
import logicFormDB.ChemReagentDB;
import logicFormDB.DBFactory;

public class Main {

	public static void main(String[] args) {
//		BioReagentForm BRFTest = new BioReagentForm(LocalDate.now(), "1", "1", "1", "1", "0", "0", "1", "1", "1", "1", "1",
//				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
//		System.out.println(BRFTest);
		DBConnection connection = new DBConnection();
//		DBOthers DBO = new DBOthers();

		DBFactory dbf = new DBFactory();

		Student std = new Student("Fornavn", "Efternavn", 0, 0);

		Course crs = new Course("DMU", 1);

		// -----------------CHEM REAGENT TEST-----------------

		ChemReagentDB cfDB = new ChemReagentDB();

//		ChemReagentContainer crc = new ChemReagentContainer();
//
		ChemReagentForm crfT = new ChemReagentForm(LocalDate.now(), "ThemeName", "AnalyzeTitel", "Comment", 0, 0,
				"scaleNo", "Volume", "Concentration", "LifeTimeF", "Storage", "ReagentName", "BatchNo", "LotNo",
				"Supplier");
//		ChemReagentForm crfT2 = new ChemReagentForm(LocalDate.now(), "ThemeName1", "AnalyzeTitel1", "Comment1", 0, 0,
//				"scaleNo1", "Volume1", "Concentration1", "LifeTimeF1", "Storage1", "ReagentName1", "BatchNo1", "LotNo1",
//				"Supplie1r");
		dbf.makeInterfaceDB().addStudent(std, crs);
//
		dbf.makeInterfaceDB().createChemReagent(crfT, std);
		System.out.println();
		System.out.println();
		dbf.makeInterfaceDB().getAllChemReagent();
		System.out.println(dbf.makeInterfaceDB().getAllChemReagent().size());
//		System.out.println(crc.getSize());
//		dbf.makeInterfaceDB().getAllForms();
//		for(int i = 0; i < dbf.makeInterfaceDB().getAllForms().size(); i++) {
//		System.out.println(dbf.makeInterfaceDB().getAllForms().get(i));
//		}
//		System.out.println(fpc.getSize());
//		for (int i = 0; i < fpc.getSize(); i++) {
//			System.out.println(fpc.getElement(i));
//		}
		// cfDB.getAllProducts(crc);
//		System.out.println(crc.getSize());
////		
////
////		
////		
//		DBO.addStudent(std, crs);
//		cfDB.addChemReagent(crfT, std);

		// -----------------BIO REAGENT CREATE TEST-----------------

//		BioReagentDB brDB = new BioReagentDB(connection);
//
//		BioReagentContainer brc = new BioReagentContainer();
	
		BioReagentForm brf = new BioReagentForm(LocalDate.now(), "1", "1", "1", 0, 0, "1", "1", "1", "1", "1", "1", "1",
				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
//		
		dbf.makeInterfaceDB().addStudent(std, crs);
		dbf.makeInterfaceDB().createBioReagent(brf, std);
		dbf.makeInterfaceDB().getAllBioReagent();
		System.out.println();
		System.out.println();
		System.out.println(dbf.makeInterfaceDB().getAllBioReagent().size());
//		dbf.makeInterfaceDB().addStudent(std, crs);
//		dbf.makeInterfaceDB().createBioReagent(brf, std);
//		System.out.println();
//		System.out.println();
//		dbf.makeInterfaceDB().getAllBioReagent(brc);
//		System.out.println(dbf.makeInterfaceDB().getAllBioReagent(brc).getSize());
//		DBO.addStudent(std, crs);
//		brDB.addBioReagent(brf, std);
//		brDB.getAllProducts(brc);
//		System.out.println(brc.getSize());

		// -----------------BIO SUBSTRATE CREATE TEST-----------------

//		BioSubstrateDB bsDB = new BioSubstrateDB(connection);
//
//		BioSubstrateContainer bsc = new BioSubstrateContainer();
////		
		BioSubstrateForm bsf = new BioSubstrateForm(LocalDate.now(), "2", "2", "2", 0, 0, "2", "2", "2", "2", "2",
				"2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", false, "2", "2", "2");
//
		dbf.makeInterfaceDB().addStudent(std, crs);
		dbf.makeInterfaceDB().createBioSubstrate(bsf, std);
		dbf.makeInterfaceDB().getAllBioSubstrate();
		System.out.println();
		System.out.println();
		System.out.println(dbf.makeInterfaceDB().getAllBioSubstrate().size());
		
//		DBO.addStudent(std, crs);
//		bsDB.addBioSubstrate(bsf, std);
//		bsDB.getAllProducts(bsc);
//		System.out.println(bsc.getSize());

	}

}
