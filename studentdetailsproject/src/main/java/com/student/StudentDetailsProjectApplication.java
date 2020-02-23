package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.model.entities.Student;
import com.student.model.repository.StudentRepo;

@SpringBootApplication
public class StudentDetailsProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentDetailsProjectApplication.class, args);
	}
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*	Student s1=new Student("shylu", "424343432", "bangalore");
		studentRepo.save(s1);
	}*/

}
}