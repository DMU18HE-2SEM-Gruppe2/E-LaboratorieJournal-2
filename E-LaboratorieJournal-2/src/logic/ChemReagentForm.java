package logic;

import java.time.LocalDate;

public class ChemReagentForm extends Form {

	private String exerciseName;
	private String weightNo;
	private String manufacturedVolume;
	private String concentration;
	private String shellLife;
	private String storage;

	public ChemReagentForm(LocalDate date, String themeName, String analyzeTitle, String comments, String reagentName,
			int batchNo, int lotNo, String supplier, String signature, String exerciseName, String weightNo,
			String manufacturedVolume, String concentration, String shellLife, String storage) {

		super(date, themeName, analyzeTitle, comments, reagentName, batchNo, lotNo, supplier, signature);
		this.exerciseName = exerciseName;
		this.weightNo = weightNo;
		this.manufacturedVolume = manufacturedVolume;
		this.concentration = concentration;
		this.shellLife = shellLife;
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

	public String getManufacturedVolume() {
		return manufacturedVolume;
	}

	public void setManufacturedVolume(String manufacturedVolume) {
		this.manufacturedVolume = manufacturedVolume;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getShellLife() {
		return shellLife;
	}

	public void setShellLife(String shellLife) {
		this.shellLife = shellLife;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "ChemReagentForm [exerciseName=" + exerciseName + ", weightNo=" + weightNo + ", manufacturedVolume="
				+ manufacturedVolume + ", concentration=" + concentration + ", shellLife=" + shellLife + ", storage="
				+ storage + ", reagentName=" + reagentName + ", batchNo=" + batchNo + ", lotNo=" + lotNo + ", supplier="
				+ supplier + ", signature=" + signature + ", date=" + date + ", themeName=" + themeName
				+ ", analyzeTitle=" + analyzeTitle + ", comments=" + comments + "]";
	}

}
