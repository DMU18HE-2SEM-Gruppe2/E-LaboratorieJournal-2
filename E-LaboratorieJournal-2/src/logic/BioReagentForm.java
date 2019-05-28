package logic;

import java.time.LocalDate;

public class BioReagentForm extends PreparationTable {

	private String adjustpH;
	private String furtherTreatment;
	private String labeling;
	private String lifeTimeF;
	private String storage;
	private String fluidAd;

	public BioReagentForm(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName, int formID, String batchNo, String lotNo, String supplier,
			String chemical, String productNo, String weighed, String measured, String scaleNo, String pipetteNo,
			String endConcentration, String adjustpH, String furtherTreatment, String labeling, String lifeTimeF,
			String storage, String fluidAd, String condition) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName, formID, batchNo, lotNo,
				supplier, chemical, productNo, weighed, measured, scaleNo, pipetteNo, fluidAd, fluidAd, condition);

		this.adjustpH = adjustpH;
		this.furtherTreatment = furtherTreatment;
		this.labeling = labeling;
		this.lifeTimeF = lifeTimeF;
		this.storage = storage;
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

	public String getLifeTimeF() {
		return lifeTimeF;
	}

	public void setLifeTimeF(String lifeTimeF) {
		this.lifeTimeF = lifeTimeF;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
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
				+ labeling + ", lifeTimeF=" + lifeTimeF + ", storage=" + storage + ", fluidAd=" + fluidAd
				+ ", chemical=" + chemical + ", casNo=" + casNo + ", productNo=" + productNo + ", weighed=" + weighed
				+ ", measured=" + measured + ", scaleNo=" + scaleNo + ", pipetteNo=" + pipetteNo + ", endConcentration="
				+ endConcentration + ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier=" + supplier
				+ ", reagentName=" + reagentName + ", formID=" + formID + ", date=" + date + ", themeName=" + themeName
				+ ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + ", analyzeID=" + analyzeID
				+ ", studentID=" + studentID + ", condition=" + condition + "]";
	}



}
