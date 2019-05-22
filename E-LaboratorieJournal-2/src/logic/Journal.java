package logic;

import java.time.LocalDate;

public class Journal extends AnalyzeInformation {

	private String coworker;
	private String traceability;
	private String results;
	private String calculations;
	// Vend tilbage - enten skal der være et variable for et billede eller en ny
	// løsning?

	public Journal(LocalDate date, String themeName, String analyzeTitle, String comments, int studentID, int analyzeID, String coworker,
			String traceability, String results, String calculations) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID);

		this.coworker = coworker;
		this.traceability = traceability;
		this.results = results;
		this.calculations = calculations;
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

	@Override
	public String toString() {
		return "Journal [coworker=" + coworker + ", traceability=" + traceability + ", results=" + results
				+ ", calculations=" + calculations + ", date=" + date + ", themeName=" + themeName + ", analyzeTitle="
				+ analyzeTitle + ", comments=" + comments + "]";
	}

}
