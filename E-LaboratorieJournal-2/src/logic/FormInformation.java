package logic;

import java.time.LocalDate;

public class FormInformation extends AnalyzeInformation {

	protected String reagentName;
	protected int formID;

	public FormInformation(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName, int formID) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID);

		this.reagentName = reagentName;
		this.formID = formID;
	}

	public String getReagentName() {
		return reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	@Override
	public String toString() {
		return "FormInformation [reagentName=" + reagentName + ", formID=" + formID + ", date=" + date + ", themeName="
				+ themeName + ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + ", analyzeID=" + analyzeID
				+ ", studentID=" + studentID + "]";
	}

}
