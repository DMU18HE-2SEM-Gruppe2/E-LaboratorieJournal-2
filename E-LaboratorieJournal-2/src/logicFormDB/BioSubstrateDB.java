package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.BioSubstrateContainer;
import data.DBConnection;
import logic.BioSubstrateForm;
import logic.FormPresentation;
import logic.Student;

public class BioSubstrateDB {

	DBConnection connection = new DBConnection();

	private boolean addAnalyzeInfo(BioSubstrateForm bioSubstrateForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment," + "condition) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, bioSubstrateForm.getDate().toEpochDay());
			add.setString(2, bioSubstrateForm.getThemeName());
			add.setString(3, bioSubstrateForm.getAnalyzeTitle());
			add.setString(4, bioSubstrateForm.getComments());
			add.setString(5, bioSubstrateForm.getCondition());

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

	private boolean addPreparation(BioSubstrateForm bioSubstrateForm) {

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

	private boolean addStudentForm(Student student, BioSubstrateForm bioSubstrateForm) {

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

	public List<BioSubstrateForm> getAllProducts() {
		return getAllProductsWhere("1=1");
	}

	public List<BioSubstrateForm> getAllProductsWhere(String whereClause) {
		List<BioSubstrateForm> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.*, formInformation.*, preparation.*, substrate_Bio.*, student.*"
					+ "FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN formInformation ON formInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN preparation ON preparation.analyzeID = formInformation.analyzeID "
					+ "JOIN substrate_Bio ON substrate_Bio.analyzeID = preparation.analyzeID WHERE " + whereClause + "";

			System.out.println(sql);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				LocalDate date = LocalDate.ofEpochDay(resultSet.getLong("dateCreated"));
				String themeName = resultSet.getString("themeName");
				String analyzeTitle = resultSet.getString("analyzeTitle");
				String comments = resultSet.getString("comment");
				int analyzeID = resultSet.getInt("analyzeID");
				int studentID = resultSet.getInt("studentID");
				String reagentName = resultSet.getString("reagentName");
				int formID = resultSet.getInt("formID");
				String batchNo = resultSet.getString("batchNo");
				String lotNo = resultSet.getString("lotNo");
				String supplier = resultSet.getString("supplier");
				String chemical = resultSet.getString("chemical");
				String casNo = resultSet.getString("casNo");
				String productNo = resultSet.getString("productNo");
				String weighed = resultSet.getString("weighed");
				String measured = resultSet.getString("measured");
				String scaleNo = resultSet.getString("scaleNo");
				String pipetteNo = resultSet.getString("pipetteNo");
				String endConcentration = resultSet.getString("endConcentration");
				String pHSubstrate = resultSet.getString("pHSubstrate");
				String pHSterialized = resultSet.getString("pHSterialized");
				String sterializeTime = resultSet.getString("sterializeTime");
				String sterializeC = resultSet.getString("sterializeC");
				String addAftSterialize = resultSet.getString("addAftSterialize");
				String pHAftSterialize = resultSet.getString("pHAftSterialize");
				boolean sterile = resultSet.getBoolean("sterile");
				String posControle = resultSet.getString("posControl");
				String negControle = resultSet.getString("negControl");
				String fluidAd = resultSet.getString("fluidAd");
				String condition = resultSet.getString("condition");

				BioSubstrateForm BSF = new BioSubstrateForm(date, themeName, analyzeTitle, comments, analyzeID,
						studentID, reagentName, formID, batchNo, lotNo, supplier, chemical, casNo, productNo, weighed, measured,
						scaleNo, pipetteNo, endConcentration, pHSubstrate, pHSterialized, sterializeTime, sterializeC,
						addAftSterialize, pHAftSterialize, sterile, posControle, negControle, fluidAd, condition);

				list.add(BSF);

			}

		} catch (SQLException e) {
			System.out.println("Error executing SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

}
