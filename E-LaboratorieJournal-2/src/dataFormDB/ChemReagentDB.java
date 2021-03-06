package dataFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.DBConnection;
import logic.ChemReagentForm;
import logic.Student;

public class ChemReagentDB {

	DBConnection connection = new DBConnection();

	private boolean addAnalyzeInfo(ChemReagentForm chemReagentForm) {

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle," + "comment,"
				+ "condition) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, chemReagentForm.getDate().toEpochDay());
			add.setString(2, chemReagentForm.getThemeName());
			add.setString(3, chemReagentForm.getAnalyzeTitle());
			add.setString(4, chemReagentForm.getComments());
			add.setString(5, chemReagentForm.getCondition());

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

		String sql = "INSERT INTO reagent_Chem (" + "analyzeID," + "volume," + "accConcentration," + "lifeTimeF,"
				+ "storage," + "batchNo," + "lotNo," + "supplier," + "scaleNo,"
				+ "measurements) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			add.setString(10, chemReagentForm.getMeasured());

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

	public boolean updateAnalyzeInformation(ChemReagentForm chemReagentForm, String whereClause) {
		String sql = "UPDATE analyzeInformation SET dateCreated = ?, " + "themeName = ?," + "analyzeTitle = ?,"
				+ "comment = ?" + "WHERE analyzeID =" + whereClause;
		try {
			PreparedStatement update = connection.getConnection().prepareStatement(sql);

			update.setLong(1, chemReagentForm.getDate().toEpochDay());
			update.setString(2, chemReagentForm.getThemeName());
			update.setString(3, chemReagentForm.getAnalyzeTitle());
			update.setString(4, chemReagentForm.getComments());

			update.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println("Error executin SQL statement");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean updateFormInformation(ChemReagentForm chemReagentForm, String whereClause) {
		String sql = "UPDATE formInformation SET reagentName = ?" + "WHERE analyzeID =" + whereClause;

		try {
			PreparedStatement update = connection.getConnection().prepareStatement(sql);

			update.setString(1, chemReagentForm.getReagentName());

			update.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println("Error executin SQL statement");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean updateChemReagentForm(ChemReagentForm chemReagentForm, String whereClause) {

		updateAnalyzeInformation(chemReagentForm, whereClause);
		updateFormInformation(chemReagentForm, whereClause);

		String sql = "UPDATE reagent_Chem SET volume = ?" + "accConcentration = ?" + "lifeTimeF = ?" + "storage = ?"
				+ "batchNo = ?" + "lotNo = ?" + "supplier = ?" + "scaleNo = ?" + "WHERE analyzeID =" + whereClause;
		try {
			PreparedStatement update = connection.getConnection().prepareStatement(sql);

			update.setString(1, chemReagentForm.getReagentName());

			update.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println("Error executin SQL statement");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean deleteAnalyzeInformation(String whereClause, ChemReagentForm chemReagentForm) {
		String sql = "DELETE FROM analyzeInformation, formInformation, student_analyzeInformation, reagent_Chem WHERE analyzeID= ?";

		try {
			PreparedStatement delete = connection.getConnection().prepareStatement(sql);
			delete.setInt(1, chemReagentForm.getAnalyzeID());
			delete.setLong(2, chemReagentForm.getDate().toEpochDay());
			delete.setString(3, chemReagentForm.getThemeName());
			delete.setString(4, chemReagentForm.getAnalyzeTitle());
			delete.setString(5, chemReagentForm.getComments());
			delete.setString(6, chemReagentForm.getCondition());
			int nRows = delete.executeUpdate();

			return (nRows == 1);
		} catch (SQLException e) {
			System.out.println("Could not delete ChemReagent: " + chemReagentForm);
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean deleteFormInformation(String whereClause, ChemReagentForm chemReagentForm) {
		String sql = "DELETE FROM formInformation WHERE analyzeID=" + whereClause;

		try {
			PreparedStatement delete = connection.getConnection().prepareStatement(sql);
			delete.setInt(1, chemReagentForm.getAnalyzeID());
			delete.setString(2, chemReagentForm.getReagentName());
			delete.executeUpdate(sql);
			System.out.println(sql);
			return true;

		} catch (SQLException e) {
			System.out.println("Error executing SQL statement");
			System.out.println(e.getMessage());
			return false;
		}
	}

	private boolean deleteStudentForm(String whereClause, ChemReagentForm chemReagentForm) {
		String sql = "DELETE * FROM student_analyzeInformation WHERE analyzeID=" + whereClause;

		try {
			PreparedStatement delete = connection.getConnection().prepareStatement(sql);
			delete.setInt(1, chemReagentForm.getStudentID());
			delete.setInt(1, chemReagentForm.getAnalyzeID());
			delete.executeUpdate(sql);
			System.out.println(sql);
			return true;

		} catch (SQLException e) {
			System.out.println("Error executing SQL statement");
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteChemReagentForm(String whereClause, ChemReagentForm chemReagentForm) {
		deleteAnalyzeInformation(whereClause, chemReagentForm);
		deleteFormInformation(whereClause, chemReagentForm);
		deleteStudentForm(whereClause, chemReagentForm);
		String sql = "DELETE FROM reagent_Chem WHERE analyzeID=" + whereClause;

		try {
			PreparedStatement delete = connection.getConnection().prepareStatement(sql);
			delete.setInt(1, chemReagentForm.getAnalyzeID());
			delete.setString(2, chemReagentForm.getVolume());
			delete.setString(3, chemReagentForm.getConcentration());
			delete.setString(4, chemReagentForm.getLifeTimeF());
			delete.setString(5, chemReagentForm.getStorage());
			delete.setString(6, chemReagentForm.getBatchNo());
			delete.setString(7, chemReagentForm.getLotNo());
			delete.setString(8, chemReagentForm.getSupplier());
			delete.setString(9, chemReagentForm.getScaleNo());
			delete.setString(10, chemReagentForm.getMeasured());
			System.out.println(sql);
			delete.executeUpdate(sql);
			return true;

		} catch (SQLException e) {
			System.out.println("Error executing SQL statement");
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
				String measured = resultSet.getString("measurements");
				String condition = resultSet.getString("condition");

				ChemReagentForm CRF = new ChemReagentForm(date, themeName, analyzeTitle, comment, analyzeID, studentID,
						scaleNo, volume, accConcentration, lifeTimeF, storage, reagentName, formID, batchNo, lotNo,
						supplier, measured, condition);

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

		String sql = "INSERT INTO reagent_Chem (" + "analyzeID," + "volume," + "accConcentration," + "lifeTimeF,"
				+ "storage," + "batchNo," + "lotNo," + "supplier," + "scaleNo"
				+ "measurements) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			add.setString(10, chemReagentForm.getMeasured());

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

}
