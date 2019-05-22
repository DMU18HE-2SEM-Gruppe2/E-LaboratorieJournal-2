package presentation;

import java.sql.SQLException;

import data.DBConnection;
import data.DBOthers;
import logic.Course;
import logic.Student;

public class Main {

	public static void main(String[] args) throws SQLException {
		DBConnection connection = new DBConnection();
		DBOthers dbOthers = new DBOthers();
//		CreateForms cf = new CreateForms(connection.getConnection());
//		
//		ChemReagentForm crf = new ChemReagentForm(LocalDate.now(), "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");

		
		// Create Course (Virker)
//		Course crs = new Course("ProTek");
//		dbOthers.addCourse(crs);
		
		// Read Course (Fejl)
//		System.out.println(dbOthers.getAllCourses());
		
		// Create Student (Skal tilgå CourseID på en eller anden måde)
		Student std = new Student("Rasmus", "Gyldenløv", 1,  2);
		Course crs = new Course("DMU", 1);
//		dbOthers.addStudent(std, crs);
		dbOthers.addStudent(std, crs);
		System.out.println(std);
		System.out.println(crs);
//		Course crs = new Course("ProTek2");
//		Student std = new Student("Peter Pedal", 2);
//		dbOthers.addStudent(std, crs);
		
		//Create 
		
//		cf.addForm1(crf);

//		System.out.println("test");
	}
	

}
