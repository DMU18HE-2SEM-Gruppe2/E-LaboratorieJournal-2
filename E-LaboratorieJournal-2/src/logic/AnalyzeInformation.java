package logic;

import java.time.LocalDate;

public class AnalyzeInformation {

	protected LocalDate date;
	protected String themeName;
	protected String analyzeTitle;
	protected String comments;
	protected int analyzeID;
	protected int studentID;

	public AnalyzeInformation(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID, int studentID) {
		this.date = date;
		this.themeName = themeName;
		this.analyzeTitle = analyzeTitle;
		this.comments = comments;
		this.analyzeID = analyzeID;
		this.studentID = studentID;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date.toEpochDay();
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getAnalyzeID() {
		return analyzeID;
	}

	public void setAnalyzeID(int analyzeID) {
		this.analyzeID = analyzeID;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	@Override
	public String toString() {
		return "AnalyzeInformation [date=" + date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle
				+ ", comments=" + comments + ", analyzeID=" + analyzeID + ", studentID=" + studentID + "]";
	}
	




}
