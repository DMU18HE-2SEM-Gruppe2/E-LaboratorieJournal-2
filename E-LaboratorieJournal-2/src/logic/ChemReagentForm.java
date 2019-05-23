package logic;

import java.time.LocalDate;

public class ChemReagentForm extends FormInformation {

	private String scaleNo;
	private String volume;
	private String concentration;
	private String lifeTimeF;
	private String storage;
	private String batchNo;
	private String lotNo;
	private String supplier;

	public ChemReagentForm(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String scaleNo, String manufacturedVolume, String concentration, String lifeTimeF,
			String storage, String reagentName, String batchNo, String lotNo, String supplier) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName);
		this.scaleNo = scaleNo;
		this.volume = manufacturedVolume;
		this.concentration = concentration;
		this.lifeTimeF = lifeTimeF;
		this.storage = storage;
		this.batchNo = batchNo;
		this.lotNo = lotNo;
		this.supplier = supplier;

	}

	public String getScaleNo() {
		return scaleNo;
	}

	public void setScaleNo(String scaleNo) {
		this.scaleNo = scaleNo;
	}

	public String getLifeTimeF() {
		return lifeTimeF;
	}

	public void setLifeTimeF(String lifeTimeF) {
		this.lifeTimeF = lifeTimeF;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String Volume) {
		this.volume = Volume;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
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
		return "ChemReagentForm [scaleNo=" + scaleNo + ", volume=" + volume + ", concentration=" + concentration
				+ ", lifeTimeF=" + lifeTimeF + ", storage=" + storage + ", batchNo=" + batchNo + ", lotNo=" + lotNo
				+ ", supplier=" + supplier + ", reagentName=" + reagentName + ", date=" + date + ", themeName="
				+ themeName + ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + ", analyzeID=" + analyzeID
				+ ", studentID=" + studentID + "]";
	}

}
