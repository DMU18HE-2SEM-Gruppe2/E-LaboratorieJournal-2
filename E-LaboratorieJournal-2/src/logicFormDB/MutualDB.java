package logicFormDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.DBConnection;
import logic.FormPresentation;

public class MutualDB {

	DBConnection connection = new DBConnection();
	
	public List<FormPresentation> getAllProductsToPresentation() {
		return getAllProductsWhereToPresentation("1=1");
	}

	public List<FormPresentation> getAllProductsWhereToPresentation(String whereClause) {
		List<FormPresentation> list = new ArrayList<>();
		try {
			String sql = "SELECT analyzeInformation.analyzeID, analyzeInformation.dateCreated, analyzeInformation.themeName, analyzeInformation.analyzeTitle, formInformation.reagentName, student.firstname, student.lastname"
					+ " FROM course JOIN student ON student.courseID = course.courseID "
					+ "JOIN student_analyzeInformation ON student_analyzeInformation.studentID = student.studentID "
					+ "JOIN analyzeInformation ON student_analyzeInformation.analyzeID = analyzeInformation.analyzeID "
					+ "JOIN formInformation ON formInformation.analyzeID = analyzeInformation.analyzeID WHERE "
					+ whereClause + " ";
			System.out.println(sql);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				LocalDate date = LocalDate.ofEpochDay(resultSet.getLong("dateCreated"));
				String themeName = resultSet.getString("themeName");
				String analyzeTitle = resultSet.getString("analyzeTitle");
				String reagentName = resultSet.getString("reagentName");
				String firstName = resultSet.getString("firstname");
				String lastName = resultSet.getString("lastname");
				int analyzeID = resultSet.getInt("analyzeID");
				String fullName = firstName + " " + lastName;

				FormPresentation fp = new FormPresentation(analyzeTitle, date, fullName, themeName, reagentName,
						analyzeID);

				list.add(fp);
			}

		} catch (SQLException e) {
			System.out.println("Error executin SQL statement");
			System.out.println(e.getMessage());
		}
		return list;
	}

	public int getAnalyzeIDByID(int id) {
		int analyzeID = 0;
		try {
			String query = "SELECT * FROM analyzeInformation WHERE analyzeID=" + id;
			System.out.println(query);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			// gennemløbe resultset
			while (resultSet.next()) { // rykker pilen i resultset fra "before first" ned på næste række.

				analyzeID = resultSet.getInt("analyzeID");

			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}

		return analyzeID;

	}
	
	
	public int getFormIDByID(int id) {
		int formID = 0;
		try {
			String query = "SELECT * FROM formInformation WHERE formID=" + id;
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
