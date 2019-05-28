package logic;

import java.time.LocalDate;

public class PreparationTable extends FormInformation {

	protected String chemical;
	protected String casNo;
	protected String productNo;
	protected String weighed;
	protected String measured;
	protected String scaleNo;
	protected String pipetteNo;
	protected String endConcentration;
	protected String batchNo;
	protected String lotNo;
	protected String supplier;

	public PreparationTable(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String reagentName, int formID, String chemical, String casNo, String productNo,
			String weighed, String measured, String scaleNo, String pipetteNo, String endConcentration, String batchNo,
			String lotNo, String supplier, String condition) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName, formID, condition);

		this.chemical = chemical;
		this.casNo = casNo;
		this.productNo = productNo;
		this.weighed = weighed;
		this.measured = measured;
		this.scaleNo = scaleNo;
		this.pipetteNo = pipetteNo;
		this.endConcentration = endConcentration;
		this.batchNo = batchNo;
		this.lotNo = lotNo;
		this.supplier = supplier;
	}

	public String getChemical() {
		return chemical;
	}

	public void setChemical(String chemical) {
		this.chemical = chemical;
	}

	public String getCasNo() {
		return casNo;
	}

	public void setCasNo(String casNo) {
		this.casNo = casNo;
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

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "PreparationTable [chemical=" + chemical + ", casNo=" + casNo + ", productNo=" + productNo + ", weighed="
				+ weighed + ", measured=" + measured + ", scaleNo=" + scaleNo + ", pipetteNo=" + pipetteNo
				+ ", endConcentration=" + endConcentration + ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier="
				+ supplier + ", reagentName=" + reagentName + ", formID=" + formID + ", date=" + date + ", themeName="
				+ themeName + ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + ", analyzeID=" + analyzeID
				+ ", studentID=" + studentID + ", condition=" + condition + "]";
	}



}
