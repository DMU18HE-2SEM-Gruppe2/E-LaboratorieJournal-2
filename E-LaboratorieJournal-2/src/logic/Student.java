package logic;

public class Student {

	private String name;
	private int courseID;
	
	// ID for student
	
	public Student(String name, int courseID) {
		
//		this.studentID = studentID;
		this.name = name;
		this.courseID = courseID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", courseID=" + courseID + "]";
	}


	
}
