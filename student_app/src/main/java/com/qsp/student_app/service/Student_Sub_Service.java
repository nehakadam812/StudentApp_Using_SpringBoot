package com.qsp.student_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.student_app.dao.Student_Subject_Dao;
import com.qsp.student_app.dto.ResponseStructure;
import com.qsp.student_app.entity.Student2;
import com.qsp.student_app.exception.StudentNullValueException;

@Service
public class Student_Sub_Service {

	   @Autowired
	   private Student_Subject_Dao dao;
	
		public ResponseEntity<ResponseStructure<Student2>> addStudent(Student2 stu) {
			
				Student2 student = dao.addStudent(stu);
				ResponseStructure<Student2> structure = new ResponseStructure<Student2>();
				structure.setStatusCode(HttpStatus.CREATED.value());
				structure.setMessage("created");
				structure.setData(student);

		return new ResponseEntity<ResponseStructure<Student2>>(structure,HttpStatus.CREATED);
	}
	
	
	
}
