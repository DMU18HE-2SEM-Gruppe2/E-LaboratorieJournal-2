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

	// CRUD Student
	// Create Student
	public boolean addStudent(Student student, Course course) {
		String query = "INSERT INTO student (" + "studentName," + 
			"courseID) VALUES (?, ?)";
	
		try {
			System.out.println(query);
			PreparedStatement add = connection.getConnection().prepareStatement(query);
			
//			add.setInt(1, student.getStudentID());
			add.setString(1, student.getName());
			add.setInt(2, course.getID());
			
			int nRows = add.executeUpdate();
			
			if (nRows != 1) {
				return false;
			}
		return true;
		} catch (SQLException e) {
			System.out.println("Failed to add: " + student);
			System.out.println(e.getMessage());
			return false;
		
		}
	}
	
	public List<Student> getAllStudents() {
		return getStudentsWhere("1=1");
	}
	
	private List<Student> getStudentsWhere(String whereClause) {
		ArrayList<Student>list = new ArrayList<Student>();
		System.out.println("før try");
		//henter resultset med alle studerende
		try {
			String query = "SELECT * FROM student WHERE " + whereClause;
			System.out.println(query);
			
			Statement statement = connection.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			//gennemløbe resultset
			while (resultSet.next()) { //rykker pilen i resultset fra "before first" ned på næste række.
				
				String name = resultSet.getString("studentName");

				int courseID = resultSet.getInt("courseID");
				
				Student student = new Student(name, courseID);
				
				list.add(student);

				
			}
		}
		catch (SQLException e) {
			System.out.println("Error running SQL statement");
			System.out.println(e.getMessage());
		}
		
		return list;
		
	}
	// CRUD Courses
}
