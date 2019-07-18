package com.aline.soap.WS;

public class Student {
	
	private int id;
	private String name;
	private String passportNumber;
	
	public Student(int id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", passportNumber=" + passportNumber + "]";
	}
}
