package logic;

import java.time.LocalDate;

public class BioSubstrateForm extends PreparationTable {

	private String pHSubstrate;
	private String pHSterialized;
	private String sterializeTime;
	private String sterializeC;
	private String addAftSterialize;
	private String pHAftSterialize;
	private boolean sterile = false;
	private String posControl;
	private String negControl;
	private String fluidAd;

	public BioSubstrateForm(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName, int formID, String batchNo, String lotNo, String supplier,
			String chemical, String casNo, String productNo, String weighed, String measured, String scaleNo,
			String pipetteNo, String endConcentration, String pHBefore, String pHEnd, String sterializeTime,
			String sterializeC, String addAftSterialize, String pHAftSterialize, boolean sterile, String posControl,
			String negControl, String fluidAd) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName, formID, batchNo, lotNo,
				supplier, chemical, casNo, productNo, weighed, measured, scaleNo, pipetteNo, fluidAd);

		this.pHSubstrate = pHBefore;
		this.pHSterialized = pHEnd;
		this.sterializeTime = sterializeTime;
		this.sterializeC = sterializeC;
		this.addAftSterialize = addAftSterialize;
		this.pHAftSterialize = pHAftSterialize;
		this.sterile = sterile;
		this.posControl = posControl;
		this.negControl = negControl;
		this.fluidAd = fluidAd;

	}

	public String getpHSubstrate() {
		return pHSubstrate;
	}

	public void setpHSubstrate(String pHSubstrate) {
		this.pHSubstrate = pHSubstrate;
	}

	public String getpHSterialized() {
		return pHSterialized;
	}

	public void setpHSterialized(String pHSterialized) {
		this.pHSterialized = pHSterialized;
	}

	public String getSterializeTime() {
		return sterializeTime;
	}

	public void setSterializeTime(String sterializeTime) {
		this.sterializeTime = sterializeTime;
	}

	public String getSterializeC() {
		return sterializeC;
	}

	public void setSterializeC(String sterializeC) {
		this.sterializeC = sterializeC;
	}

	public String getAddAftSterialize() {
		return addAftSterialize;
	}

	public void setAddAftSterialize(String addAftSterialize) {
		this.addAftSterialize = addAftSterialize;
	}

	public String getpHAftSterialize() {
		return pHAftSterialize;
	}

	public void setpHAftSterialize(String pHAftSterialize) {
		this.pHAftSterialize = pHAftSterialize;
	}

	public boolean isSterile() {
		return sterile;
	}

	public void setSterile(boolean sterile) {
		this.sterile = sterile;
	}

	public String getPosControl() {
		return posControl;
	}

	public void setPosControl(String posControl) {
		this.posControl = posControl;
	}

	public String getNegControl() {
		return negControl;
	}

	public void setNegControl(String negControl) {
		this.negControl = negControl;
	}

	public String getFluidAd() {
		return fluidAd;
	}

	public void setFluidAd(String fluidAd) {
		this.fluidAd = fluidAd;
	}

	@Override
	public String toString() {
		return "BioSubstrateForm [pHSubstrate=" + pHSubstrate + ", pHSterialized=" + pHSterialized + ", sterializeTime="
				+ sterializeTime + ", sterializeC=" + sterializeC + ", addAftSterialize=" + addAftSterialize
				+ ", pHAftSterialize=" + pHAftSterialize + ", sterile=" + sterile + ", posControl=" + posControl
				+ ", negControl=" + negControl + ", fluidAd=" + fluidAd + ", chemical=" + chemical + ", casNo=" + casNo
				+ ", productNo=" + productNo + ", weighed=" + weighed + ", measured=" + measured + ", scaleNo="
				+ scaleNo + ", pipetteNo=" + pipetteNo + ", endConcentration=" + endConcentration + ", batchNo="
				+ batchNo + ", lotNo=" + lotNo + ", supplier=" + supplier + ", reagentName=" + reagentName + ", formID="
				+ formID + ", date=" + date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle
				+ ", comments=" + comments + ", analyzeID=" + analyzeID + ", studentID=" + studentID + "]";
	}

}
