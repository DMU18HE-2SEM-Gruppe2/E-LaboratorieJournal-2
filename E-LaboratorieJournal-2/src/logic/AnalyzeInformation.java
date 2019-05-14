package logic;

import java.time.LocalDate;

public class AnalyzeInformation {

	protected LocalDate date;
	protected String themeName;
	protected String analyzeTitle;
	protected String comments;

	public AnalyzeInformation(LocalDate date, String themeName, String analyzeTitle, String comments) {
		this.date = date;
		this.themeName = themeName;
		this.analyzeTitle = analyzeTitle;
		this.comments = comments;
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

	@Override
	public String toString() {
		return "ProjectInformation [date=" + date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle
				+ ", comments=" + comments + "]";
	}

}
