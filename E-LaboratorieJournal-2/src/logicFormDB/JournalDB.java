package logicFormDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.DBConnection;
import logic.FormPresentation;
import logic.Journal;
import logic.JournalPresentation;
import logic.Student;

public class JournalDB {
	private DBConnection connection = new DBConnection();

	public boolean addAnalyzeInfo(Journal journal) {

//		public Journal(LocalDate date, String themeName, String analyzeTitle, String comments, int studentID, int analyzeID,
//				String coworker, String traceability, String results, String calculations, String image)

		String sql = "INSERT INTO analyzeInformation (" + "dateCreated," + "themeName," + "analyzeTitle," + "comment,"
				+ "condition) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setLong(1, journal.getDate().toEpochDay());
			add.setString(2, journal.getThemeName());
			add.setString(3, journal.getAnalyzeTitle());
			add.setString(4, journal.getComments());
			add.setString(5, journal.getCondition());

			System.out.println(sql);
			int nRows = add.executeUpdate();

			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						journal.setAnalyzeID(add.getGeneratedKeys().getInt(1));
						System.out.println(journal);
						return true;
					}
				}
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + journal);
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addJournal(Journal journal) {
		String sql = "INSERT INTO journal (" + "analyzeID," + "coworker," + "traceability," + "results,"
				+ "calculations," + "calcImage) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement add = connection.getConnection().prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS)) {
			System.out.println(sql);

			add.setInt(1, journal.getAnalyzeID());
			add.setString(2, journal.getCoworker());
			add.setString(3, journal.getTraceability());
			add.setString(4, journal.getResults());
			add.setString(5, journal.getCalculations());
			add.setString(6, journal.getImage());

			System.out.println(sql);
			int nRows = add.executeUpdate();

			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						journal.setJournalID(add.getGeneratedKeys().getInt(1));
						System.out.println(journal);
						return true;
					}
				}
			}
			return true;

		} catch (SQLException e) {
			System.out.println("Failed to add: " + journal);
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean addStudentForm(Student student, Journal journal) {
		addAnalyzeInfo(journal);
		addJournal(journal);

		String sql = "INSERT INTO student_analyzeInformation (" + "studentID," + "analyzeID) VALUES (?, ?)";
		System.out.println(sql);

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, student.getStudentID());
			add.setInt(2, journal.getAnalyzeID());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + journal);
			System.out.println(e.getMessage());
			return false;

		}

	}

	public boolean addJournalForm(int whereClause) {

		List<Journal> list = readAllJournals();

		Journal j = list.get(list.size() - 1);

		String sql = "INSERT INTO journalForm (" + "journalID," + "formID) VALUES (?, ?)";

		try {
			System.out.println(sql);
			PreparedStatement add = connection.getConnection().prepareStatement(sql);

			add.setInt(1, j.getJournalID());
			add.setInt(2, whereClause);

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + j);
			System.out.println(e.getMessage());
			return false;

		}
	}

	public List<JournalPresentation> getAllJournalsToPresentation() {
		return getAllJournalsWhereToPresentation("1=1");
	}

	public List<JournalPresentation> getAllJournalsWhereToPresentation(String whereClause) {
		List<JournalPresentation> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.*, journal.*, student.*"
					+ " FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN journal ON journal.analyzeID = analyzeInformation.analyzeID WHERE " + whereClause
					+ "";
			System.out.println(sql);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				LocalDate date = LocalDate.ofEpochDay(resultSet.getLong("dateCreated"));
				String themeName = resultSet.getString("themeName");
				String analyzeTitle = resultSet.getString("analyzeTitle");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				String traceability = resultSet.getString("traceability");
				String condition = resultSet.getString("condition");
				int analyzeID = resultSet.getInt("analyzeID");
				String fullName = firstName + " " + lastName;

				JournalPresentation jp = new JournalPresentation(date, themeName, analyzeTitle, fullName, traceability,
						condition, analyzeID);

				list.add(jp);
			}

		} catch (SQLException e) {
			System.out.println("Error executin SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<Journal> readAllJournals() {
		return readJournal("1=1");
	}

	public List<Journal> readJournal(String whereClause) {
		
		
		DBFactory dbf = new DBFactory();
		
		List<Journal> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.*, journal.*, student.*, formInformation.*"
					+ " FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN journal ON journal.analyzeID = student_analyzeInformation.analyzeID WHERE " + whereClause
					+ "";
			System.out.println(sql);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				LocalDate date = LocalDate.ofEpochDay(resultSet.getLong("dateCreated"));
				String themeName = resultSet.getString("themeName");
				String analyzeTitle = resultSet.getString("analyzeTitle");
				String comments = resultSet.getString("comment");
				int studentID = resultSet.getInt("studentID");
				int analyzeID = resultSet.getInt("analyzeID");
				String coworker = resultSet.getString("coworker");
				String traceability = resultSet.getString("traceability");
				String results = resultSet.getString("results");
				String calculations = resultSet.getString("calculations");
				String image = resultSet.getString("calcImage");
				int journalID = resultSet.getInt("journalID");
				int formID = resultSet.getInt("formID");
				String condition = resultSet.getString("condition");

				Journal journal = new Journal(LocalDate.now(), themeName, analyzeTitle, comments, studentID, analyzeID,
						coworker, traceability, results, calculations, image, journalID, formID, condition);

				list.add(journal);

			}

		} catch (SQLException e) {
			System.out.println("Error executing the SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public List<Journal> readFormToJournalWhere(String whereClause) {
		List<Journal> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.analyzeID, formInformation.formID, student.*"
					+ "FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN journal ON journal.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN journalForm ON journalForm.journalID = journal.journalID WHERE " + whereClause + "";

			System.out.println(sql);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				LocalDate date = LocalDate.ofEpochDay(resultSet.getLong("dateCreated"));
				String themeName = resultSet.getString("themeName");
				String analyzeTitle = resultSet.getString("analyzeTitle");
				String comments = resultSet.getString("comment");
				int studentID = resultSet.getInt("studentID");
				int analyzeID = resultSet.getInt("analyzeID");
				String coworker = resultSet.getString("coworker");
				String traceability = resultSet.getString("traceability");
				String results = resultSet.getString("results");
				String calculations = resultSet.getString("calculations");
				String image = resultSet.getString("image");
				int journalID = resultSet.getInt("journalID");
				int formID = resultSet.getInt("formID");
				String condition = resultSet.getString("condition");

				Journal journal = new Journal(LocalDate.now(), themeName, analyzeTitle, comments, studentID, analyzeID,
						coworker, traceability, results, calculations, image, journalID, formID, condition);

				list.add(journal);

			}

		} catch (SQLException e) {
			System.out.println("Error executing the SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int getFormIDByID(int id) {
		int formID = 0;
		try {
			String query = "SELECT * FROM formInformation WHERE analyzeID=" + id;
			System.out.println(query);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			// gennemløbe resultset
			while (resultSet.next()) { // rykker pilen i resultset fra "before first" ned på næste række.

				formID = resultSet.getInt("formID");

			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}

		return formID;
	}

}
