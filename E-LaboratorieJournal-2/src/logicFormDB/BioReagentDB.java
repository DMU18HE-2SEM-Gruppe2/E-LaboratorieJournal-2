package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.DBConnection;
import logic.BioReagentForm;
import logic.Student;

public class BioReagentDB {
	private DBConnection connection;


	public BioReagentDB(DBConnection connection) {
		this.connection = connection;
	}

	private boolean addAnalyzeInfo(BioReagentForm bioReagentForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment) VALUES (?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, bioReagentForm.getDate().toEpochDay());
			add.setString(2, bioReagentForm.getThemeName());
			add.setString(3, bioReagentForm.getAnalyzeTitle());
			add.setString(4, bioReagentForm.getComments());

			System.out.println(sql);
			int nRows = add.executeUpdate();

			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						bioReagentForm.setAnalyzeID(add.getGeneratedKeys().getInt(1));
						System.out.println(bioReagentForm);
						return true;
					}
				}
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioReagentForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean addFormInformation(BioReagentForm bioReagentForm) {

		String sql = "INSERT INTO formInformation (" + "analyzeID," + "reagentName" + ") VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, bioReagentForm.getAnalyzeID());
			add.setString(2, bioReagentForm.getReagentName());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioReagentForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addPreparation(BioReagentForm bioReagentForm) {

		String sql = "INSERT INTO preparation (" + "analyzeID," + "chemical," + "casNo," + "productNo," + "weighed,"
				+ "measured," + "scaleNo," + "pipetteNo," + "endConcentration," + "batchNo," + "lotNo," + "supplier"
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);

			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, bioReagentForm.getAnalyzeID());
			add.setString(2, bioReagentForm.getChemical());
			add.setString(3, bioReagentForm.getCasNo());
			add.setString(4, bioReagentForm.getProductNo());
			add.setString(5, bioReagentForm.getWeighed());
			add.setString(6, bioReagentForm.getMeasured());
			add.setString(7, bioReagentForm.getScaleNo());
			add.setString(8, bioReagentForm.getPipetteNo());
			add.setString(9, bioReagentForm.getEndConcentration());
			add.setString(10, bioReagentForm.getBatchNo());
			add.setString(11, bioReagentForm.getLotNo());
			add.setString(12, bioReagentForm.getSupplier());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioReagentForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addStudentForm(Student student, BioReagentForm bioReagentForm) {

		String sql = "INSERT INTO student_analyzeInformation (" + "studentID," + "analyzeID) VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, student.getStudentID());
			add.setInt(2, bioReagentForm.getAnalyzeID());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioReagentForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addBioReagent(BioReagentForm bioReagentForm, Student student) {
		addAnalyzeInfo(bioReagentForm);
		addFormInformation(bioReagentForm);
		addPreparation(bioReagentForm);
		addStudentForm(student, bioReagentForm);
		System.out.println("StudentForm");

		String sql = "INSERT INTO reagent_Bio (" + "analyzeID," + "phSetting," + "treatment," + "tag," + "lifeTimeF,"
				+ "storage," + "fluidAd) VALUES (?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, bioReagentForm.getAnalyzeID());
			add.setString(2, bioReagentForm.getAdjustpH());
			add.setString(3, bioReagentForm.getFurtherTreatment());
			add.setString(4, bioReagentForm.getLabeling());
			add.setString(5, bioReagentForm.getLifeTimeF());
			add.setString(6, bioReagentForm.getStorage());
			add.setString(7, bioReagentForm.getFluidAd());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioReagentForm);
			System.out.println(e.getMessage());
			return false;
		}
	}
}
