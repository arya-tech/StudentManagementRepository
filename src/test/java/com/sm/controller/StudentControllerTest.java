package com.sm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sm.entites.Student;
import com.sm.service.StudentService;

@WebMvcTest(value = StudentController.class)
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService service;
	
	@Test
	public void test_saveStudentInfo() throws Exception {
		Student student=new Student("stud03","bapu solunke", new Date(),new Date());
		
		//when(service.saveStudent(student)).thenReturn("");
		
		
		
		ObjectMapper mapper=new ObjectMapper();
		String studentJson = mapper.writeValueAsString(student);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveStudent").contentType("application/json").content(studentJson);
		
		 MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		 
		 int status = mvcResult.getResponse().getStatus();
		 
		 assertEquals(201, status);
		
	}
	
}
