package com.sm.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sm.dto.StudentDto;
import com.sm.entites.Student;
import com.sm.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping(value = "/saveStudent",consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> saveStudentInfo(@RequestBody Student student) {
		StudentDto dto=null;
		dto = service.saveStudent(student);
		return new ResponseEntity<>(dto.getStudentName()+" record hase been stored successfully!!.",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getStudentInfo", produces = MediaType.APPLICATION_JSON)
	public List<StudentDto> getAllStudentInfo(){
		List<StudentDto> studentList = service.getAllStudent();
		System.out.println(studentList);
		return studentList;
	}
	
	@GetMapping(value = "/updateStudentInfo/{studentNo}/{studentName}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentNo")String studentNo, @PathVariable("studentName") String studentName){
		String msg=null;
		if(studentNo!=null || studentNo.trim().length()!=0 || studentName!=null || studentName.trim().length()!=0) {
			msg=service.updateStudentInfo(studentNo, studentName);
		}
		if(msg!=null) {
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		return new ResponseEntity<String>("failde to update student info.",HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/removeStudent/{studentNo}")
	public ResponseEntity<String> removeStudent(@PathVariable("studentNo") String studentNo){
		String msg = service.deleteStudent(studentNo);
		if(msg==null) {
		return new ResponseEntity<String>("failed to remove the record with student no :"+studentNo,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
