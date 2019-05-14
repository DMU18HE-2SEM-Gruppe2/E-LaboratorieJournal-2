package logic;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		BioReagentForm BRFTest = new BioReagentForm(LocalDate.now(), "1", "1", "1", "1", "0", "0", "1", "1", "1", "1", "1",
				"1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
		System.out.println(BRFTest);

	}

}
