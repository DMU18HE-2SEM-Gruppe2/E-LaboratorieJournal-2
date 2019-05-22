package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.Course;
import logic.Student;

public class DBOthers {

	DBConnection connection = new DBConnection();

	public boolean addStudent(Student student, Course course) {
		String query = "INSERT INTO student (" + "firstname," + "lastname," + "courseID"
				+ ") VALUES (?, ?, ?)";
		// CRUD Student
		// Create Student
		
		try (PreparedStatement add = connection.getConnection().prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS)) {
			add.setString(1, student.getFirstName());
			add.setString(2, student.getLastName());
			add.setInt(3, course.getCourseID());
			
			int nRows = add.executeUpdate();

			student.setCourseID(course.getCourseID());
			
			if (nRows > 0) {
				try (ResultSet rs = add.getGeneratedKeys()) {
					if (rs.next()) {
						student.setStudentID(add.getGeneratedKeys().getInt(1));
						return true;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}


//	public boolean addStudent(Student student, Course course) {
//
//		String select = "SELECT courseID FROM course WHERE " + "courseName=" + "'" + course.getName() + "'";
//		String query = "INSERT INTO student (" + "studentID," + "firstname," + "lastname," + "courseID"
//				+ ") VALUES (?, ?, ?, ?)";
//
//		try {
//
//			PreparedStatement g = connection.getConnection().prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
//
//			PreparedStatement add = connection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//
//			System.out.println(query);
//			System.out.println(select);
//
//			g.executeUpdate();
//			int nRows = add.executeUpdate();
//
//			ResultSet generatedKeys = add.getGeneratedKeys();
//			ResultSet generatedCourseID = g.getGeneratedKeys();
//
//			if (generatedCourseID.next()) {
//				course.setCourseID(generatedCourseID.getInt(1));
//			}
//
//			if (generatedKeys.next()) {
//				student.setStudentID(generatedKeys.getInt(1));
//			}
//
//			add.setInt(1, student.getStudentID());
//			add.setString(2, student.getFirstName());
//			add.setString(3, student.getLastName());
//			add.setInt(4, course.getCourseID());
//
//			if (nRows != 1) {
//				System.out.println("Fejl1");
//				return false;
//			}
//			return true;
//		} catch (SQLException e) {
//			System.out.println("Fejl2");
//			System.out.println("Failed to add: " + student);
//			System.out.println(e.getMessage());
//			return false;
//
//		}
//	}

	// Read All Students
	public List<Student> getAllStudents() {
		return getStudentsWhere("1=1");
	}

	// Read Some Students
	private List<Student> getStudentsWhere(String whereClause) {
		ArrayList<Student> list = new ArrayList<Student>();
		System.out.println("før try");
		// henter resultset med alle studerende
		try {
			String query = "SELECT * FROM student WHERE " + whereClause;
			System.out.println(query);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			// gennemløbe resultset
			while (resultSet.next()) { // rykker pilen i resultset fra "before first" ned på næste række.

				String firstName = resultSet.getString("firstname");

				String lastName = resultSet.getString("lastname");

				int studentID = resultSet.getInt("studentID");

				int courseID = resultSet.getInt("courseID");

				Student student = new Student(firstName, lastName, courseID, studentID);

				list.add(student);

			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}

		return list;

	}

	// CRUD Courses
	// Create Course
	public boolean addCourse(Course course) {
		String query = "INSERT INTO course (" + "courseName" + ") VALUES (?)";

		try {
			System.out.println(query);
			PreparedStatement add = connection.getConnection().prepareStatement(query);

			add.setString(1, course.getName());

			int nRows = add.executeUpdate();

			if (nRows != 1) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + course);
			System.out.println(e.getMessage());
			return false;

		}
	}

	// Read All Courses
	public List<Course> getAllCourses() {
		return getCoursesWhere("1=1");
	}

	// Read Course
	private List<Course> getCoursesWhere(String whereClause) {
		ArrayList<Course> list = new ArrayList<Course>();
		// henter resultset med alle courses
		try {
			String query = "SELECT * FROM course WHERE " + whereClause;
			System.out.println(query);

			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			// gennemløbe resultset
			while (resultSet.next()) { // rykker pilen i resultset fra "before first" ned på næste række.

				String courseName = resultSet.getString("courseName");

				int courseID = resultSet.getInt("courseID");

				Course course = new Course(courseName, courseID);

				list.add(course);

			}
		} catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}

		return list;

	}
}
