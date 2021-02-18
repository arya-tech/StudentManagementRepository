package com.sm.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class StudentProject implements Serializable {
	
	@Id
	@Column(name="designation")
	protected String designation;
	
	@EmbeddedId
	protected StudentProjectKey studentProjectKey;
	
	@ManyToOne
	@MapsId("studentNo")
	@JoinColumn(name="student_no")
	protected Student student;
	
	@ManyToOne
	@MapsId("projectNo")
	@JoinColumn(name="prj_no")
	protected Project project;
}
