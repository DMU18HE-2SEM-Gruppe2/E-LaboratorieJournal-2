package logic;

import java.time.LocalDate;

public class BioSubstrateForm extends PreparationTable {

	private double pHBefore;
	private double pHEnd;
	private String sterilisation;
	private String additionAfter;
	private double pHAfterSteril;
	private boolean steril = false;
	private String posControl;
	private String negControl;
	private String fluidAd;

	public BioSubstrateForm(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName, String batchNo, String lotNo, String supplier, int pageNo,
			String signature, String chemical, String easNo, String productNo, String weighed, String measured,
			String scaleNo, String pipetteNo, String endConcentration, double pHBefore, double pHEnd,
			String sterilisation, String additionAfter, double pHAfterSteril, boolean steril, String posControl,
			String negControl, String fluidAd) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName, batchNo, lotNo, supplier,
				signature, chemical, easNo, productNo, weighed, measured, scaleNo, pipetteNo);

		this.pHBefore = pHBefore;
		this.pHEnd = pHEnd;
		this.sterilisation = sterilisation;
		this.additionAfter = additionAfter;
		this.pHAfterSteril = pHAfterSteril;
		this.steril = steril;
		this.posControl = posControl;
		this.negControl = negControl;
		this.fluidAd = fluidAd;

	}

	public double getpHBefore() {
		return pHBefore;
	}

	public void setpHBefore(double pHBefore) {
		this.pHBefore = pHBefore;
	}

	public double getpHEnd() {
		return pHEnd;
	}

	public void setpHEnd(double pHEnd) {
		this.pHEnd = pHEnd;
	}

	public String getSterilisation() {
		return sterilisation;
	}

	public void setSterilisation(String sterilisation) {
		this.sterilisation = sterilisation;
	}

	public String getAdditionAfter() {
		return additionAfter;
	}

	public void setAdditionAfter(String additionAfter) {
		this.additionAfter = additionAfter;
	}

	public double getpHAfterSteril() {
		return pHAfterSteril;
	}

	public void setpHAfterSteril(double pHAfterSteril) {
		this.pHAfterSteril = pHAfterSteril;
	}

	public boolean isSteril() {
		return steril;
	}

	public void setSteril(boolean steril) {
		this.steril = steril;
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
		return "BioSubstrateForm [pHBefore=" + pHBefore + ", pHEnd=" + pHEnd + ", sterilisation=" + sterilisation
				+ ", additionAfter=" + additionAfter + ", pHAfterSteril=" + pHAfterSteril + ", steril=" + steril
				+ ", posControl=" + posControl + ", negControl=" + negControl + ", fluidAd=" + fluidAd + ", chemical="
				+ chemical + ", easNo=" + easNo + ", productNo=" + productNo + ", weighed=" + weighed + ", measured="
				+ measured + ", scaleNo=" + scaleNo + ", pipetteNo=" + pipetteNo + ", endConcentration="
				+ endConcentration + ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier=" + supplier
				+ ", reagentName=" + reagentName + ", date=" + date + ", themeName=" + themeName + ", analyzeTitle="
				+ analyzeTitle + ", comments=" + comments + ", analyzeID=" + analyzeID + ", studentID=" + studentID
				+ "]";
	}

}
