package logic;

import java.time.LocalDate;

public class JournalPresentation {

	LocalDate date;
	String themeName, analyzeTitle, studentNames, traceability, condition;
	int analyzeID;

	public JournalPresentation(LocalDate date, String themeName, String analyzeTitle, String studentNames,
			String traceability, String condition, int analyzeID) {
		this.date = date;
		this.themeName = themeName;
		this.analyzeTitle = analyzeTitle;
		this.studentNames = studentNames;
		this.traceability = traceability;
		this.condition = condition;
		this.analyzeID = analyzeID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getAnalyzeTitle() {
		return analyzeTitle;
	}

	public void setAnalyzeTitle(String analyzeTitle) {
		this.analyzeTitle = analyzeTitle;
	}

	public String getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(String studentNames) {
		this.studentNames = studentNames;
	}

	public String getTraceability() {
		return traceability;
	}

	public void setTraceability(String traceability) {
		this.traceability = traceability;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getAnalyzeID() {
		return analyzeID;
	}

	public void setAnalyzeID(int analyzeID) {
		this.analyzeID = analyzeID;
	}

	@Override
	public String toString() {
		return "JournalPresentation [date=" + date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle
				+ ", studentNames=" + studentNames + ", traceability=" + traceability + ", condition=" + condition
				+ ", analyzeID=" + analyzeID + "]";
	}

}
