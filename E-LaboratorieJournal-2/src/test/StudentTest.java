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
		student = new Student("John", 1);
	}

	@After
	public void tearDown() {
		student = new Student("John", 1);
	}

	@Test
	public void studentConstructor() {
		assertEquals("[name=John, courseID=1]", student.toString());
	}
	
}
