package logic;

import java.time.LocalDate;

public class PreparationTable extends Form {

	protected String chemical;
	protected String easNo;
	protected String productNo;
	protected String weighed;
	protected String measured;
	protected String scaleNo;
	protected String pipetteNo;
	protected String endConcentration;
	protected String fluidAd;

	public PreparationTable(LocalDate date, String themeName, String analyzeTitle, String comments, String reagentName,
			int batchNo, int lotNo, String supplier, String signature, String chemical, String easNo,
			String productNo, String weighed, String measured, String scaleNo, String pipetteNo,
			String endConcentration, String fluidAd) {

		super(date, themeName, analyzeTitle, comments, reagentName, batchNo, lotNo, supplier, signature);

		this.chemical = chemical;
		this.easNo = easNo;
		this.productNo = productNo;
		this.weighed = weighed;
		this.measured = measured;
		this.scaleNo = scaleNo;
		this.pipetteNo = pipetteNo;
		this.endConcentration = endConcentration;
		this.fluidAd = fluidAd;
	}

	public String getChemical() {
		return chemical;
	}

	public void setChemical(String chemical) {
		this.chemical = chemical;
	}

	public String getEasNo() {
		return easNo;
	}

	public void setEasNo(String easNo) {
		this.easNo = easNo;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getWeighed() {
		return weighed;
	}

	public void setWeighed(String weighed) {
		this.weighed = weighed;
	}

	public String getMeasured() {
		return measured;
	}

	public void setMeasured(String measured) {
		this.measured = measured;
	}

	public String getScaleNo() {
		return scaleNo;
	}

	public void setScaleNo(String scaleNo) {
		this.scaleNo = scaleNo;
	}

	public String getPipetteNo() {
		return pipetteNo;
	}

	public void setPipetteNo(String pipetteNo) {
		this.pipetteNo = pipetteNo;
	}

	public String getEndConcentration() {
		return endConcentration;
	}

	public void setEndConcentration(String endConcentration) {
		this.endConcentration = endConcentration;
	}

	public String getFluidAd() {
		return fluidAd;
	}

	public void setFluidAd(String fluidAd) {
		this.fluidAd = fluidAd;
	}

}
