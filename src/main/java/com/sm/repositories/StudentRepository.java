package com.sm.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable> {
	
	public Student save(Student student);
	
	public List<Student> findAll();
	
	public Student findByStudentNo(String studentNo);
	
	public String deleteByStudentNo(String studentNo);
	

}
