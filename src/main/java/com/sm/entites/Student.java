package com.sm.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {
	
	@Id
	@Column(name="student_no")
	protected String studentNo;
	@Column(name="student_name")
	protected String studentName;
	@Column(name="student_dob")
	protected Date studentDob;
	@Column(name="student_doj")
	protected Date studentDoj;
	
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "student_project",joinColumns
	 * = @JoinColumn(name="student_no"),inverseJoinColumns
	 * = @JoinColumn(name="prj_no"))
	 */
	
	/*
	 * @OneToMany(mappedBy = "student") protected Set<Project> projects;
	 * 
	 * 
	 * 
	 * public Set<Project> getProjects() { return projects; } public void
	 * setProjects(Set<Project> projects) { this.projects = projects; }
	 */
	@OneToMany(mappedBy = "student")
	protected Set<StudentProject> studentProjects;
	
	
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
	public Student(String studentNo, String studentName, Date studentDob, Date studentDoj) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentDoj = studentDoj;
		this.studentProjects = studentProjects;
	}
	public Student() {
		super();
	}
	
	
	
	
}
