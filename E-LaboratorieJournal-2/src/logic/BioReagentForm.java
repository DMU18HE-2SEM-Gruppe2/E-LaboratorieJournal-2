package logic;

import java.time.LocalDate;

public class BioReagentForm extends PreparationTable {

	private String adjustpH;
	private String furtherTreatment;
	private String labeling;
	private String shellLife;
	private String fluidAd;

	public BioReagentForm(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName, String batchNo, String lotNo, String supplier, String signature,
			String chemical, String easNo, String productNo, String weighed, String measured, String scaleNo,
			String pipetteNo, String endConcentration, String adjustpH, String furtherTreatment,
			String labeling, String shellLife, String fluidAd) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName, batchNo, lotNo, supplier,
				signature, chemical, easNo, productNo, weighed, measured, scaleNo, pipetteNo);

		this.adjustpH = adjustpH;
		this.furtherTreatment = furtherTreatment;
		this.labeling = labeling;
		this.shellLife = shellLife;
		this.fluidAd = fluidAd;
	}

	public String getAdjustpH() {
		return adjustpH;
	}

	public void setAdjustpH(String adjustpH) {
		this.adjustpH = adjustpH;
	}

	public String getFurtherTreatment() {
		return furtherTreatment;
	}

	public void setFurtherTreatment(String furtherTreatment) {
		this.furtherTreatment = furtherTreatment;
	}

	public String getLabeling() {
		return labeling;
	}

	public void setLabeling(String labeling) {
		this.labeling = labeling;
	}

	public String getShellLife() {
		return shellLife;
	}

	public void setShellLife(String shellLife) {
		this.shellLife = shellLife;
	}

	public String getFluidAd() {
		return fluidAd;
	}

	public void setFluidAd(String fluidAd) {
		this.fluidAd = fluidAd;
	}

	@Override
	public String toString() {
		return "BioReagentForm [adjustpH=" + adjustpH + ", furtherTreatment=" + furtherTreatment + ", labeling="
				+ labeling + ", shellLife=" + shellLife + ", fluidAd=" + fluidAd + ", chemical=" + chemical + ", easNo="
				+ easNo + ", productNo=" + productNo + ", weighed=" + weighed + ", measured=" + measured + ", scaleNo="
				+ scaleNo + ", pipetteNo=" + pipetteNo + ", endConcentration=" + endConcentration + ", batchNo="
				+ batchNo + ", lotNo=" + lotNo + ", supplier=" + supplier + ", reagentName=" + reagentName + ", date="
				+ date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle + ", comments=" + comments
				+ ", analyzeID=" + analyzeID + ", studentID=" + studentID + "]";
	}

}
