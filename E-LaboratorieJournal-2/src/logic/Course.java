package logic;

public class Course {
	
	private String name;
	private int ID;
	
	public Course(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", ID=" + ID + "]";
	}
	
	
	
	
	
}
