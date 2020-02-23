package com.student.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exceptionhandler.StudentNotFoundEx;
import com.student.model.entities.Student;
import com.student.model.repository.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> findStudentById(Long id) {
		return studentRepo.findById(id);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student studentToBeUpdated=studentRepo.findById(id).orElseThrow(StudentNotFoundEx::new);
		studentToBeUpdated.setCity(student.getCity());
		return studentRepo.save(studentToBeUpdated);
		
	}

}
