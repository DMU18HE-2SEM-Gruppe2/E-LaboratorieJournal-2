package logic;

import java.time.LocalDate;

public class ChemReagentForm extends FormInformation {

	private String exerciseName;
	private String weightNo;
	private String volume;
	private String concentration;
	private String lifeTimeF;
	private String storage;
	private String batchNo;
	private String lotNo;
	private String supplier;

	public ChemReagentForm(LocalDate date, String themeName, String analyzeTitle, String comments, int analyzeID,
			int studentID, String exerciseName, String weightNo, String manufacturedVolume, String concentration,
			String lifeTimeF, String storage, String reagentName, String batchNo, String lotNo, String supplier) {

		super(date, themeName, analyzeTitle, comments, analyzeID, studentID, reagentName);
		this.exerciseName = exerciseName;
		this.weightNo = weightNo;
		this.volume = manufacturedVolume;
		this.concentration = concentration;
		this.lifeTimeF = lifeTimeF;
		this.storage = storage;
		this.batchNo = batchNo;
		this.lotNo = lotNo;
		this.supplier = supplier;

	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getWeightNo() {
		return weightNo;
	}

	public void setWeightNo(String weightNo) {
		this.weightNo = weightNo;
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

	public String getlifeTimeF() {
		return lifeTimeF;
	}

	public void setlifeTimeF(String lifeTimeF) {
		this.lifeTimeF = lifeTimeF;
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
		return "ChemReagentForm [exerciseName=" + exerciseName + ", weightNo=" + weightNo + ", volume=" + volume
				+ ", concentration=" + concentration + ", lifeTimeF=" + lifeTimeF + ", storage=" + storage
				+ ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier=" + supplier + ", reagentName="
				+ reagentName + ", date=" + date + ", themeName=" + themeName + ", analyzeTitle=" + analyzeTitle
				+ ", comments=" + comments + ", analyzeID=" + analyzeID + ", studentID=" + studentID + "]";
	}

}
