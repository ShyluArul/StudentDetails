package com.student.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
