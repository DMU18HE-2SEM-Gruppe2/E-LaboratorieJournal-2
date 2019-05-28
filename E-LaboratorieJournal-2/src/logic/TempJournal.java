package logic;

import java.time.LocalDate;

public class TempJournal {

	private String coworker;
	private String traceability;
	private String results;
	private String calculations;
	private String image;
	private LocalDate date;
	private String themeName;
	private String analyzeTitle;
	private int journalID;
	private int analyzeID;
	

	public TempJournal(String coworker, String traceability, String results, String calculations, String image,
			LocalDate date, String themeName, String analyzeTitle, int journalID, int analyzeID) {
		super();
		this.coworker = coworker;
		this.traceability = traceability;
		this.results = results;
		this.calculations = calculations;
		this.image = image;
		this.date = date;
		this.themeName = themeName;
		this.analyzeTitle = analyzeTitle;
		this.journalID = journalID;
		this.analyzeID = analyzeID;
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


	public int getJournalID() {
		return journalID;
	}


	public void setJournalID(int journalID) {
		this.journalID = journalID;
	}


	public int getAnalyzeID() {
		return analyzeID;
	}


	public void setAnalyzeID(int analyzeID) {
		this.analyzeID = analyzeID;
	}


	@Override
	public String toString() {
		return "TempJournal [coworker=" + coworker + ", traceability=" + traceability + ", results=" + results
				+ ", calculations=" + calculations + ", image=" + image + ", date=" + date + ", themeName=" + themeName
				+ ", analyzeTitle=" + analyzeTitle + ", journalID=" + journalID + ", analyzeID=" + analyzeID + "]";
	}

}