package com.sm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dto.StudentDto;
import com.sm.entites.Student;
import com.sm.repositories.StudentRepository;


@Service
public class StudentProjectManagementServicesImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public StudentDto saveStudent(Student student) {
		StudentDto studentDto=new StudentDto();
		Student student1 = studentRepository.save(student);
		BeanUtils.copyProperties(student1, studentDto);
		return studentDto;
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<StudentDto> studentDtos=new ArrayList<>();
		List<Student> students=studentRepository.findAll();
		return students.stream().map(student->{
			StudentDto dto=new StudentDto();
			BeanUtils.copyProperties(student, dto);
			return dto;
		}).collect(Collectors.toList());
		
	}

	@Override
	public String updateStudentInfo(String studentNo, String studentName) {
		String msg=null;
		Student student = studentRepository.findByStudentNo(studentNo);
		student.setStudentName(studentName);
		studentRepository.save(student);
		return msg="student :"+studentNo+" update with name :"+studentName;
	}

	@Override
	@Transactional
	public String deleteStudent(String studentNo) {
		String msg=null;
		studentRepository.deleteByStudentNo(studentNo);
		Student student = studentRepository.findByStudentNo(studentNo);
		if(student==null) {
			return msg="student record with student No :"+studentNo+" is removed successfully.. ";
		}
		return msg="failde to delete the record..";
	}
	
	
	
	

}
