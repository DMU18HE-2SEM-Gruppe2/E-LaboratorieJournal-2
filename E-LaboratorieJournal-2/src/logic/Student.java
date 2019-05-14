package logic;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {

	private String name;
	private int studentID;
	
	// ID for student
	private static final AtomicInteger studentCounter = new AtomicInteger();
	
	public Student(String name, int studentID) {
		int studentCounterInteger = studentCounter.incrementAndGet();
		
		this.name = name;
		this.studentID = studentCounterInteger;
	}
}
