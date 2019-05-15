package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.ChemReagentForm;

public class ChemReagentFormTest {
//	ChemReagentForm crfTest;
//
//	@Before
//	public void setUp() {
//		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", "Grisefedt",
//				"1a2b3c", "", "GH Kemi", "FJERN SIGNATURE", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%",
//				"2 dage", "Køleskab");
//	}
//	
//	@After
//	public void tearDown() {
//		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", "Grisefedt",
//				"1a2b3c", "", "GH Kemi", "FJERN SIGNATURE", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%",
//				"2 dage", "Køleskab");
//	}
	@Test
	public void chemReagentFormConstructor() {
		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", "Grisefedt",
				"1a2b3c", "", "GH Kemi", "FJERN SIGNATURE", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%",
				"2 dage", "Køleskab");
		assertEquals(
				"[exerciseName=Sæbe test, weightNo=vægt med udluft nr. 3, manufacturedVolume=300mL, concentration=20%, "
						+ "lifeTimeF=2 dage, storage=Køleskab, reagentName=Grisefedt, batchNo=1a2b3c, lotNo=, supplier=GH Kemi, "
						+ "signature=FJERN SIGNATURE, date=2019-05-15, themeName=Sæbe, analyzeTitle=Brun Sæbe test, comments=]",
				crfTest.toString());
	}

	@Test
	public void chemReagentFormDate() {
		ChemReagentForm crfTest = new ChemReagentForm(LocalDate.now(), "Sæbe", "Brun Sæbe test", "", "Grisefedt",
				"1a2b3c", "", "GH Kemi", "FJERN SIGNATURE", "Sæbe test", "vægt med udluft nr. 3", "300mL", "20%",
				"2 dage", "Køleskab");
		assertEquals(LocalDate.now(), crfTest.getDate());
	}
}
