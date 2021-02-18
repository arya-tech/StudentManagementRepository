package com.sm.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
// class to generate composite primary key

@Embeddable
public class StudentProjectKey implements Serializable {

	@Column(name="student_no")
	protected String studentNo;
	@Column(name="prj_no")
	protected String projectNo;
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectNo == null) ? 0 : projectNo.hashCode());
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentProjectKey other = (StudentProjectKey) obj;
		if (projectNo == null) {
			if (other.projectNo != null)
				return false;
		} else if (!projectNo.equals(other.projectNo))
			return false;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		return true;
	}
}
