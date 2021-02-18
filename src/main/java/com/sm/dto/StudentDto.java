package com.sm.dto;

import java.util.Date;

public class StudentDto {
	
	
	
	public StudentDto() {
		super();
	}
	
	
	public StudentDto(String studentNo, String studentName, Date studentDob, Date studentDoj) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentDoj = studentDoj;
	}
	private String studentNo;
	private String studentName;
	private Date studentDob;
	private Date studentDoj;
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(Date studentDob) {
		this.studentDob = studentDob;
	}
	public Date getStudentDoj() {
		return studentDoj;
	}
	public void setStudentDoj(Date studentDoj) {
		this.studentDoj = studentDoj;
	}
	

}
