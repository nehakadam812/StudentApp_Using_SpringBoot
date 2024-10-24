package com.qsp.student_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.student_app.entity.Student2;

public interface StudentRepository extends JpaRepository<Student2, Integer>{
	
	   public Student2 findByEmail(String email);
	   public Student2 findByName(String name);
	   public Student2 findByPhone(long phone);
	   

}
