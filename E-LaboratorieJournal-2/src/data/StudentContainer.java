package data;

import java.util.ArrayList;
import java.util.List;

import logic.Student;

public class StudentContainer {

	DBConnection connection = new DBConnection();

	DBOthers DBO = new DBOthers();

	List<Student> list = new ArrayList<Student>();

	public void addElement(Student newStudent) {
		list.add(newStudent);
	}

	public void deleteElement(Student studentToDelete) {
		list.remove(studentToDelete);
	}

	public Student getElement(int index) {
		return list.get(index);
	}

	public int getSize() {
		return list.size();
	}

	public void addStudentToList() {
		for (int i = 0; i < DBO.getAllStudents().size(); i++) {
			list.add(DBO.getAllStudents().get(i));
		}
	}

}
