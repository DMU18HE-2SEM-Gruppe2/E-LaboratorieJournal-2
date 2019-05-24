package logic;

public class Student {

	private String firstName;
	private String lastName;
	private int courseID;
	private int studentID;

	// ID for student

	public Student(String firstName, String lastName, int courseID, int studentID) {

		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseID = courseID;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
