package presentation;

import data.DBConnection;
import data.DBOthers;
import logic.Course;
import logic.Student;

public class Main {

	public static void main(String[] args) {
		DBConnection connection = new DBConnection();
		DBOthers dbOthers = new DBOthers();
//		CreateForms cf = new CreateForms(connection.getConnection());
//		
//		ChemReagentForm crf = new ChemReagentForm(LocalDate.now(), "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
		
		Course crs = new Course("DMU", 1);
		
		int i = crs.getID();
		Student std = new Student("John", 1);
		dbOthers.addStudent(std, crs);
		
//		cf.addForm1(crf);

//		System.out.println("test");
	}
	

}
