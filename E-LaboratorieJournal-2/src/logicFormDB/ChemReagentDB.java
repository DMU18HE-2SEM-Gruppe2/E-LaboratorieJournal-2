package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.DBConnection;
import logic.ChemReagentForm;
import logic.FormPresentation;
import logic.Student;

public class ChemReagentDB {

	DBConnection connection = new DBConnection();

	private boolean addAnalyzeInfo(ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle,"
				+ "comment) VALUES (?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, chemReagentForm.getDate().toEpochDay());
			add.setString(2, chemReagentForm.getThemeName());
			add.setString(3, chemReagentForm.getAnalyzeTitle());
			add.setString(4, chemReagentForm.getComments());

			System.out.println(sql);
			int nRows = add.executeUpdate();

			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						chemReagentForm.setAnalyzeID(add.getGeneratedKeys().getInt(1));
						System.out.println(chemReagentForm);
						return true;
					}
				}
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + chemReagentForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean addFormInformation(ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO formInformation (" + "analyzeID," + "reagentName" + ") VALUES (?, ?)";
		System.out.println(sql);
		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, chemReagentForm.getAnalyzeID());
			add.setString(2, chemReagentForm.getReagentName());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + chemReagentForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	private boolean addStudentForm(Student student, ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO student_analyzeInformation (" + "studentID," + "analyzeID) VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, student.getStudentID());
			add.setInt(2, chemReagentForm.getAnalyzeID());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + chemReagentForm);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addChemReagent(ChemReagentForm chemReagentForm, Student student) {
		addAnalyzeInfo(chemReagentForm);
		addFormInformation(chemReagentForm);
		addStudentForm(student, chemReagentForm);
		System.out.println("StudentForm");

		String sql = "INSERT INTO reagent_Chem (" + "analyzeID," + "volume," + "accConcentration," + "lifeTimeF,"
				+ "storage," + "batchNo," + "lotNo," + "supplier," + "scaleNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, chemReagentForm.getAnalyzeID());
			add.setString(2, chemReagentForm.getVolume());
			add.setString(3, chemReagentForm.getConcentration());
			add.setString(4, chemReagentForm.getLifeTimeF());
			add.setString(5, chemReagentForm.getStorage());
			add.setString(6, chemReagentForm.getBatchNo());
			add.setString(7, chemReagentForm.getLotNo());
			add.setString(8, chemReagentForm.getSupplier());
			add.setString(9, chemReagentForm.getScaleNo());

			int nRows = add.executeUpdate();
			System.out.println(chemReagentForm);
			if (nRows != 1) {
				return false;
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + chemReagentForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<ChemReagentForm> getAllProducts() {
		return getAllProductsWhere("1=1");
	}

	public List<ChemReagentForm> getAllProductsWhere(String whereClause) {
		List<ChemReagentForm> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.*, formInformation.*, reagent_Chem.*, student.*"
					+ " FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN formInformation ON formInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN reagent_Chem ON reagent_Chem.analyzeID = formInformation.analyzeID WHERE " + whereClause
					+ "";
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
				String scaleNo = resultSet.getString("scaleNo");
				String volume = resultSet.getString("volume");
				String accConcentration = resultSet.getString("accConcentration");
				String lifeTimeF = resultSet.getString("lifeTimeF");
				String storage = resultSet.getString("storage");
				String reagentName = resultSet.getString("reagentName");
				int formID = resultSet.getInt("formID");
				String batchNo = resultSet.getString("batchNo");
				String lotNo = resultSet.getString("lotNo");
				String supplier = resultSet.getString("supplier");

				ChemReagentForm CRF = new ChemReagentForm(date, themeName, analyzeTitle, comment, analyzeID, studentID,
						scaleNo, volume, accConcentration, lifeTimeF, storage, reagentName, formID, batchNo, lotNo,
						supplier);

				list.add(CRF);
			}

		} catch (SQLException e) {
			System.out.println("Error executin SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public boolean addChemReagentToPresentation(ChemReagentForm chemReagentForm, Student student) {
		addAnalyzeInfo(chemReagentForm);
		addFormInformation(chemReagentForm);
		addStudentForm(student, chemReagentForm);
		System.out.println("StudentForm");

		String sql = "INSERT INTO reagent_Chem (" + "analyzeID," + "volume," + "accConcentration," + "lifeTimeF,"
				+ "storage," + "batchNo," + "lotNo," + "supplier," + "scaleNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);

		try {
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, chemReagentForm.getAnalyzeID());
			add.setString(2, chemReagentForm.getVolume());
			add.setString(3, chemReagentForm.getConcentration());
			add.setString(4, chemReagentForm.getLifeTimeF());
			add.setString(5, chemReagentForm.getStorage());
			add.setString(6, chemReagentForm.getBatchNo());
			add.setString(7, chemReagentForm.getLotNo());
			add.setString(8, chemReagentForm.getSupplier());
			add.setString(9, chemReagentForm.getScaleNo());

			int nRows = add.executeUpdate();
			System.out.println(chemReagentForm);
			if (nRows != 1) {
				return false;
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + chemReagentForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

}
