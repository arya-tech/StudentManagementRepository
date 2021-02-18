package com.sm.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {
	@Id
	@Column(name = "prj_no")
	protected String projectNo;
	@Column(name = "prj_name")
	protected String projectName;
	@Column(name = "prj_duration")
	protected Integer projectDuration;
	@Column(name = "prj_platform")
	protected String projectPlatform;

	/*
	 * @OneToMany(mappedBy = "project") protected Set<Student> students;
	 * 
	 * public Set<Student> getStudents() { return students; }
	 * 
	 * public void setStudents(Set<Student> students) { this.students = students; }
	 */
	
	
	@OneToMany(mappedBy = "project")
	protected Set<StudentProject> studentProjects;

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(Integer projectDuration) {
		this.projectDuration = projectDuration;
	}

	public String getProjectPlatform() {
		return projectPlatform;
	}

	public void setProjectPlatform(String projectPlatform) {
		this.projectPlatform = projectPlatform;
	}

}
