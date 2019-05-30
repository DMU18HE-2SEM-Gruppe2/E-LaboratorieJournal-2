package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DBConnection;
import dataFormDB.ImplDB;
import logic.ChemReagentForm;

public class ChemReagentFormTest {

	ChemReagentForm crf;

	DBConnection connection = new DBConnection();
	ImplDB implDB = new ImplDB();

	@Before
	public void setUp() {
		crf = new ChemReagentForm(LocalDate.now(), "Sukker", "pH måling", "Der var mange fejl", 0, 0,
				"Vægt 4 udluftning", "4", "2 mol", "2 uger", "I skabet", "P20h", 0, "23-291-499586", "", "G.H Kemi",
				"Ja", "Gemt");
	}

	@After
	public void tearDown() {
		crf = new ChemReagentForm(LocalDate.now(), "Sukker", "pH måling", "Der var mange fejl", 0, 0,
				"Vægt 4 udluftning", "4", "2 mol", "2 uger", "I skabet", "P20h", 0, "23-291-499586", "", "G.H Kemi",
				"Ja", "Gemt");
	}

	@Test
	public void ToString() {
		assertEquals(
				"ChemReagentForm [scaleNo=Vægt 4 udluftning, volume=4, concentration=2 mol, lifeTimeF=2 uger, storage=I skabet, batchNo=23-291-499586, lotNo=, supplier=G.H Kemi, measured=Ja, reagentName=P20h, formID=0, date="
						+ LocalDate.now() + ", "
						+ "themeName=Sukker, analyzeTitle=pH måling, comments=Der var mange fejl, analyzeID=0, studentID=0, condition=Gemt]",
				crf.toString());
	}

	@Test
	public void getThemeName() {
		assertEquals("Sukker", crf.getThemeName());
		System.out.println(crf.toString());
	}

	@Test
	public void setThemeName() {
		crf.setThemeName("Druesukker");
		assertEquals("Druesukker", crf.getThemeName());
	}

}
