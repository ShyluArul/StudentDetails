package com.student.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentdetails")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String studentName;
	public String mobileNumber;
	public String city;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Student(String studentName, String mobileNumber, String city) {
		super();
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", mobileNumber=" + mobileNumber + ", city=" + city + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
