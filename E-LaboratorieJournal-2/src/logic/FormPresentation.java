package logic;

import java.time.LocalDate;

public class FormPresentation {

	private String title, studentName, themeName, reagentName, condition;
	private LocalDate date;
	private int analyzeID;

	public FormPresentation(String title, LocalDate date, String studentName, String themeName, String reagentName,
			int analyzeID, String condition) {
		this.title = title;
		this.date = date;
		this.studentName = studentName;
		this.themeName = themeName;
		this.reagentName = reagentName;
		this.analyzeID = analyzeID;
		this.condition = condition;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getReagentName() {
		return reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
	}

	public int getAnalyzeID() {
		return analyzeID;
	}

	public void setAnalyzeID(int analyzeID) {
		this.analyzeID = analyzeID;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "FormPresentation [title=" + title + ", date=" + date + ", studentName=" + studentName + ", themeName="
				+ themeName + ", reagentName=" + reagentName + ", analyzeID=" + analyzeID + ", condition=" + condition
				+ "]";
	}

}
