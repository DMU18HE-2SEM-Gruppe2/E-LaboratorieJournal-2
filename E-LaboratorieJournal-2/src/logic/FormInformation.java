package logic;

import java.time.LocalDate;

public class FormInformation extends AnalyzeInformation {

	protected String reagentName;

	public FormInformation(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID);

		this.reagentName = reagentName;
	}

	public String getReagentName() {
		return reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
	}

	@Override
	public String toString() {
		return "FormInformation [reagentName=" + reagentName + "]";
	}

}
