package com.qsp.student_app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.student_app.entity.Student2;
import com.qsp.student_app.entity.Subject;
import com.qsp.student_app.repository.StudentRepository;
import com.qsp.student_app.repository.SubjectRepository;
@Repository
public class Student_Subject_Dao {
	@Autowired
	private SubjectRepository subRepo;
	@Autowired
	private StudentRepository stuRepo;
	
	
	public Student2  addStudent(Student2 student ) {
		for(Subject sub:student.getSub()) {
			subRepo.save(sub);
			
		}
		return stuRepo.save(student);
		
		
		
	}
	

}
