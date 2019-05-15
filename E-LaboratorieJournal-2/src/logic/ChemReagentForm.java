package logic;

import java.time.LocalDate;

public class ChemReagentForm extends FormInformation {

	private String exerciseName;
	private String weightNo;
	private String volume;
	private String concentration;
	private String lifeTimeF;
	private String storage;

	public ChemReagentForm(LocalDate date, String themeName, String analyzeTitle, String comments, String reagentName,
			String batchNo, String lotNo, String supplier, String signature, String exerciseName, String weightNo,
			String manufacturedVolume, String concentration, String lifeTimeF, String storage) {

		super(date, themeName, analyzeTitle, comments, reagentName, batchNo, lotNo, supplier, signature);
		this.exerciseName = exerciseName;
		this.weightNo = weightNo;
		this.volume = manufacturedVolume;
		this.concentration = concentration;
		this.lifeTimeF = lifeTimeF;
		this.storage = storage;

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

	@Override
	public String toString() {
		return "[exerciseName=" + exerciseName + ", weightNo=" + weightNo + ", manufacturedVolume="
				+ volume + ", concentration=" + concentration + ", lifeTimeF=" + lifeTimeF + ", storage="
				+ storage + ", reagentName=" + reagentName + ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier="
				+ supplier + ", signature=" + signature + ", date=" + date + ", themeName=" + themeName
				+ ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + "]";
	}

}
