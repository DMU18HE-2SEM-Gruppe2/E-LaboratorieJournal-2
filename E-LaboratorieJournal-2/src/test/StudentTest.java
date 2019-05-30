package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logic.Student;

public class StudentTest {

	private Student student;

	@Before
	public void setUp() {
		student = new Student("Jon", "Snow", 1, 1);
	}

	@After
	public void tearDown() {
		student = new Student("Jon", "Snow", 1, 1);
	}

	@Test
	public void Constructor() {
		assertEquals("Jon Snow", student.toString());
	}

	@Test
	public void GetFirstName() {
		assertEquals("Jon", student.getFirstName());
	}

	@Test
	public void GetLastName() {
		assertEquals("Snow", student.getLastName());
	}

	@Test
	public void FirstName() {
		student.setFirstName("John");
		assertEquals("John", student.getFirstName());
	}

	@Test
	public void SetLastName() {
		student.setLastName("Cena");
		assertEquals("Cena", student.getLastName());
	}

	@Test
	public void GetID() {
		assertEquals(1, student.getStudentID());
	}

	@Test
	public void GetCourseID() {
		assertEquals(1, student.getCourseID());
	}

	@Test
	public void SetID() {
		student.setStudentID(99);
		assertEquals(99, student.getStudentID());
	}

	@Test
	public void SetCourseID() {
		student.setCourseID(69);
		assertEquals(69, student.getCourseID());
	}

	@Test
	public void ToString() {
		assertEquals("Jon Snow", student.toString());
	}

}
