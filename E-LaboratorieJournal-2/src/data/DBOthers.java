package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	// CRUD Courses
	}
}
