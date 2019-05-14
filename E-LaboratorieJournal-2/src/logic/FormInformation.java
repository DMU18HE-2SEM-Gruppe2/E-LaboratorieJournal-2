package logic;

import java.time.LocalDate;

public class FormInformation extends AnalyzeInformation {

	protected String reagentName;
	protected String batchNo;
	protected String lotNo;
	protected String supplier;
	protected String signature;

	public FormInformation(LocalDate date, String themeName, String analyzeTitle, String comments, String reagentName, String batchNo,
			String lotNo, String supplier, String signature) {

		super(date, themeName, analyzeTitle, comments);

		this.reagentName = reagentName;
		this.batchNo = batchNo;
		this.lotNo = lotNo;
		this.supplier = supplier;
		this.signature = signature;
	}

	public String getReagentName() {
		return reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "Form [reagentName=" + reagentName + ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier="
				+ supplier + ", signature=" + signature + ", date=" + date + ", themeName=" + themeName
				+ ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + "]";
	}

}
