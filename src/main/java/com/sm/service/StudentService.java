package com.sm.service;

import com.sm.entites.Student;

import java.util.List;

import com.sm.dto.StudentDto;


public interface StudentService {
	
	public StudentDto saveStudent(Student student);
	
	public List<StudentDto> getAllStudent();
	
	public String updateStudentInfo(String studentNo,String studentName);
	
	public String deleteStudent(String studentNo);

}
