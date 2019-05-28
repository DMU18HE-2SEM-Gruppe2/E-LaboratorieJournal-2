package logic;

import java.time.LocalDate;

public class Journal extends AnalyzeInformation {

	private String coworker;
	private String traceability;
	private String results;
	private String calculations;
	private String image;
	private int journalID;
	private int formID;

	public Journal(LocalDate date, String themeName, String analyzeTitle, String comments, int studentID, int analyzeID,
			String coworker, String traceability, String results, String calculations, String image, int journalID,
			int formID, String condition) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, condition);

		this.coworker = coworker;
		this.traceability = traceability;
		this.results = results;
		this.calculations = calculations;
		this.image = image;
		this.journalID = journalID;
		this.formID = formID;
	}

	public String getCoworker() {
		return coworker;
	}

	public void setCoworker(String coworker) {
		this.coworker = coworker;
	}

	public String getTraceability() {
		return traceability;
	}

	public void setTraceability(String traceability) {
		this.traceability = traceability;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getCalculations() {
		return calculations;
	}

	public void setCalculations(String calculations) {
		this.calculations = calculations;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getJournalID() {
		return journalID;
	}

	public void setJournalID(int journalID) {
		this.journalID = journalID;
	}

	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	@Override
	public String toString() {
		return "Journal [coworker=" + coworker + ", traceability=" + traceability + ", results=" + results
				+ ", calculations=" + calculations + ", image=" + image + ", journalID=" + journalID + ", formID="
				+ formID + ", date=" + date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle
				+ ", comments=" + comments + ", analyzeID=" + analyzeID + ", studentID=" + studentID + ", condition="
				+ condition + "]";
	}



}
