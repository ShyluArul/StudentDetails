package com.student.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.exceptionhandler.StudentNotFoundEx;
import com.student.model.entities.Student;
import com.student.model.service.StudentService;

@RestController
@RequestMapping(path="/api")
public class StudentRestController {

	private StudentService studentService;
	@Autowired
public StudentRestController(StudentService studentService) {
		
		this.studentService = studentService;
	}
	@GetMapping(path="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>>getAllStudents(){
		return new  ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping(path="/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student>getAnStudent(@PathVariable(name="id")Long id){
		Student student=studentService.findStudentById(id).orElseThrow(StudentNotFoundEx::new);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	
	}
	@DeleteMapping(path="/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>deleteAnStudent(@PathVariable(name="id")Long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(path="student/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student>updateAnStudent(@PathVariable(name="id")Long id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(id, student),HttpStatus.OK);
	}
		@PostMapping(path="student")
		public ResponseEntity<Student>addAnStudent(/*@Valid*/ @RequestBody Student student){
			return new ResponseEntity<Student>(studentService.addStudent(student),HttpStatus.CREATED);
		}
}
