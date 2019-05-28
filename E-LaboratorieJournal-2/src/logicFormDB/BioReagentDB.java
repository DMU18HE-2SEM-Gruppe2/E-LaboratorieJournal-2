package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.BioReagentContainer;
import data.DBConnection;
import logic.BioReagentForm;
import logic.FormPresentation;
import logic.Student;

public class BioReagentDB {

	DBConnection connection = new DBConnection();

	private boolean addAnalyzeInfo(BioReagentForm bioReagentForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment," + "condition) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, bioReagentForm.getDate().toEpochDay());
			add.setString(2, bioReagentForm.getThemeName());
			add.setString(3, bioReagentForm.getAnalyzeTitle());
			add.setString(4, bioReagentForm.getComments());
			add.setString(5, bioReagentForm.getCondition());

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

	private boolean addPreparation(BioReagentForm bioReagentForm) {

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

	private boolean addStudentForm(Student student, BioReagentForm bioReagentForm) {

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

	public List<BioReagentForm> getAllProducts() {
		return getAllProductsWhere("1=1");
	}

	public List<BioReagentForm> getAllProductsWhere(String whereClause) {
		List<BioReagentForm> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.*, formInformation.*, preparation.*, reagent_Bio.*, student.*"
					+ "FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN formInformation ON formInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN preparation ON preparation.analyzeID = formInformation.analyzeID "
					+ "JOIN reagent_Bio ON reagent_Bio.analyzeID = preparation.analyzeID WHERE " + whereClause + "";

			System.out.println(sql);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				LocalDate date = LocalDate.ofEpochDay(resultSet.getLong("dateCreated"));
				String themeName = resultSet.getString("themeName");
				String analyzeTitle = resultSet.getString("analyzeTitle");
				String comment = resultSet.getString("comment");
				int analyzeID = resultSet.getInt("analyzeID");
				int studentID = resultSet.getInt("studentID");
				String reagentName = resultSet.getString("reagentName");
				int formID = resultSet.getInt("formID");
				String batchNo = resultSet.getString("batchNo");
				String lotNo = resultSet.getString("lotNo");
				String supplier = resultSet.getString("supplier");
				String chemical = resultSet.getString("chemical");
				String productNo = resultSet.getString("productNo");
				String weighed = resultSet.getString("weighed");
				String measured = resultSet.getString("measured");
				String scaleNo = resultSet.getString("scaleNo");
				String pipetteNo = resultSet.getString("pipetteNo");
				String endConcentration = resultSet.getString("endConcentration");
				String adjustpH = resultSet.getString("pHSetting");
				String furtherTreatment = resultSet.getString("treatment");
				String labeling = resultSet.getString("tag");
				String lifeTimeF = resultSet.getString("lifeTimeF");
				String storage = resultSet.getString("storage");
				String fluidAd = resultSet.getString("fluidAd");
				String condition = resultSet.getString("condition");

				BioReagentForm brf = new BioReagentForm(date, themeName, analyzeTitle, comment, analyzeID, studentID,
						reagentName, formID, batchNo, lotNo, supplier, chemical, productNo, weighed, measured, scaleNo,
						pipetteNo, endConcentration, adjustpH, furtherTreatment, labeling, lifeTimeF, storage, fluidAd, condition);

				list.add(brf);

			}
		} catch (SQLException e) {
			System.out.println("Error executing SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

}
