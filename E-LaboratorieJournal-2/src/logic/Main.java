package logic;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
//		BioReagentForm BRFTest = new BioReagentForm(LocalDate.now(), "1", "1", "1", "1", "0", "0", "1", "1", "1", "1", "1",
//				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
//		System.out.println(BRFTest);
		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", "Grisefedt", "1a2b3c",
				"", "GH Kemi", "FJERN SIGNATURE", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%", "2 dage",
				"Køleskab");
		
		System.out.println(crfTest.toString());

	}

}
