package com.student.model.service;

import java.util.List;
import java.util.Optional;

import com.student.model.entities.Student;


public interface StudentService {
	public List<Student>getAllStudents();
	public Optional<Student>findStudentById(Long id);
	public void deleteStudent(Long id);
	public Student addStudent(Student student);
	public Student updateStudent(Long id,Student student);


}
