package net.msyy.service;

import java.util.List;

import net.msyy.model.Student;

public interface StudentService {

	
	public void save(Student stu);
	
	public List students();
	
	public Student getStudentById(int student_id);
}
