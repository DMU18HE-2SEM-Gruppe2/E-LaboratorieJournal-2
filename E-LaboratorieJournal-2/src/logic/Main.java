package logic;

import java.time.LocalDate;

import data.DBConnection;
import dataFormDB.BioReagentDB;
import dataFormDB.ChemReagentDB;
import dataFormDB.DBFactory;

public class Main {

	public static void main(String[] args) {
		DBConnection connection = new DBConnection();

		DBFactory dbf = new DBFactory();

		Student std = new Student("Fornavn", "Efternavn", 0, 0);

		Course crs = new Course("DMU", 1);

		// -----------------CHEM REAGENT TEST-----------------

//
		ChemReagentForm crfT = new ChemReagentForm(LocalDate.now(), "ThemeName", "AnalyzeTitel", "Comment", 0, 0,
				"scaleNo", "Volume", "Concentration", "LifeTimeF", "Storage", "ReagentName", 0, "BatchNo", "LotNo",
				"Supplier", null, null);
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

		BioReagentForm brf = new BioReagentForm(LocalDate.now(), "1", "1", "1", 0, 0, "1", 0, "1", "1", "1", "1", "1", "1",
				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", null);
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
		BioSubstrateForm bsf = new BioSubstrateForm(LocalDate.now(), "2", "2", "2", 0, 0, "2", 0, "2", "2", "2", "2", "2",
				"2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", false, "2", "2", "2", null);
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
