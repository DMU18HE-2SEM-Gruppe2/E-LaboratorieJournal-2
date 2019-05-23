package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.DBConnection;
import logic.BioSubstrateForm;
import logic.Student;

public class JournalDB {
	private DBConnection connection;

	public JournalDB(DBConnection connection) {
		this.connection = connection;
	}

	private boolean addAnalyzeInfo(BioSubstrateForm bioSubstrateForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment) VALUES (?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, bioSubstrateForm.getDate().toEpochDay());
			add.setString(2, bioSubstrateForm.getThemeName());
			add.setString(3, bioSubstrateForm.getAnalyzeTitle());
			add.setString(4, bioSubstrateForm.getComments());

			System.out.println(sql);
			int nRows = add.executeUpdate();

			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						bioSubstrateForm.setAnalyzeID(add.getGeneratedKeys().getInt(1));
						System.out.println(bioSubstrateForm);
						return true;
					}
				}
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioSubstrateForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean addFormInformation(BioSubstrateForm bioSubstrateForm) {

		String sql = "INSERT INTO formInformation (" + "analyzeID," + "reagentName" + ") VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, bioSubstrateForm.getAnalyzeID());
			add.setString(2, bioSubstrateForm.getReagentName());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioSubstrateForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addPreparation(BioSubstrateForm bioSubstrateForm) {

		String sql = "INSERT INTO preparation (" + "analyzeID," + "chemical," + "casNo," + "productNo," + "weighed,"
				+ "measured," + "scaleNo," + "pipetteNo," + "endConcentration," + "batchNo," + "lotNo," + "supplier"
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);

			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, bioSubstrateForm.getAnalyzeID());
			add.setString(2, bioSubstrateForm.getChemical());
			add.setString(3, bioSubstrateForm.getCasNo());
			add.setString(4, bioSubstrateForm.getProductNo());
			add.setString(5, bioSubstrateForm.getWeighed());
			add.setString(6, bioSubstrateForm.getMeasured());
			add.setString(7, bioSubstrateForm.getScaleNo());
			add.setString(8, bioSubstrateForm.getPipetteNo());
			add.setString(9, bioSubstrateForm.getEndConcentration());
			add.setString(10, bioSubstrateForm.getBatchNo());
			add.setString(11, bioSubstrateForm.getLotNo());
			add.setString(12, bioSubstrateForm.getSupplier());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioSubstrateForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addStudentForm(Student student, BioSubstrateForm bioSubstrateForm) {

		String sql = "INSERT INTO student_analyzeInformation (" + "studentID," + "analyzeID) VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, student.getStudentID());
			add.setInt(2, bioSubstrateForm.getAnalyzeID());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioSubstrateForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addBioSubstrate(BioSubstrateForm bioSubstrateForm, Student student) {
		addAnalyzeInfo(bioSubstrateForm);
		addFormInformation(bioSubstrateForm);
		addPreparation(bioSubstrateForm);
		addStudentForm(student, bioSubstrateForm);
		System.out.println("StudentForm");

		String sql = "INSERT INTO substrate_Bio (" + "analyzeID," + "pHSubstrate," + "pHSterialized,"
				+ "sterializeTime," + "sterializeC," + "addAftSterialize," + "pHAftSterialize," + "sterile,"
				+ "posControl," + "negControl," + "fluidAd) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, bioSubstrateForm.getAnalyzeID());
			add.setString(2, bioSubstrateForm.getpHSubstrate());
			add.setString(3, bioSubstrateForm.getpHSterialized());
			add.setString(4, bioSubstrateForm.getSterializeTime());
			add.setString(5, bioSubstrateForm.getSterializeC());
			add.setString(6, bioSubstrateForm.getAddAftSterialize());
			add.setString(7, bioSubstrateForm.getpHAftSterialize());
			add.setBoolean(8, bioSubstrateForm.isSterile());
			add.setString(9, bioSubstrateForm.getPosControl());
			add.setString(10, bioSubstrateForm.getNegControl());
			add.setString(11, bioSubstrateForm.getFluidAd());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + bioSubstrateForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

}
