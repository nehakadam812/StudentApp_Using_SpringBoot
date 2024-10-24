package com.qsp.student_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.qsp.student_app.dao.Student_Subject_Dao;
import com.qsp.student_app.dto.ResponseStructure;
import com.qsp.student_app.entity.Student2;
import com.qsp.student_app.entity.Subject;
import com.qsp.student_app.service.StudentService;
import com.qsp.student_app.service.Student_Sub_Service;
import com.qsp.student_app.service.SubjectService;

@RestController
@RequestMapping("/qsp")
public class StudentController {
	@Autowired
	StudentService service;
	@Autowired
	SubjectService subService;
	@Autowired
	private Student_Sub_Service ser;
	
    @PostMapping("/stu/sub")
	public ResponseEntity<ResponseStructure<Student2>> addSubj(@RequestBody Student2 stu) {
		return ser.addStudent(stu);
		
	}
	
    
	
	
	@PostMapping("/stu2")
	public ResponseEntity<ResponseStructure<Student2>> saveStudent(@RequestBody Student2 student) {

		return service.saveStudent(student);
	}
	@PostMapping("/stu2/update")
	public ResponseEntity<ResponseStructure<Student2>> updateStudent(@RequestBody Student2 student) {

		return service.updateStudent(student);
	}
	
	@GetMapping("/stu2/all")
	public ResponseEntity<ResponseStructure<List<Student2>>> name() {
		return service.findAll();
		
	}

	@GetMapping("/stu2/find/{id}")
	public ResponseEntity<ResponseStructure<Student2>> FindStudentById(@PathVariable int id) {

		return service.findById(id);
	}
	
	@DeleteMapping("/stu2/delete/{id}")
	public ResponseEntity<ResponseStructure<Student2>> deleteStudentById(@PathVariable int id) {

		return service.deleteById(id);
	}
	
	@GetMapping("/stu2/phone/{phone}")
	public ResponseEntity<ResponseStructure<Student2>> FindStudentByPhone(@PathVariable long phone) {

		return service.findByPhone(phone);
	}
	@GetMapping("/stu2/email/{email}")
	public ResponseEntity<ResponseStructure<Student2>> FindStudentByEmail(@PathVariable String email) {

		return service.findByEmail(email);
	}
	

	@PostMapping("/sub")
	public ResponseEntity<ResponseStructure<Subject>> saveSubject(@RequestBody Subject subject) {

		return subService.saveSubject(subject);
		
	}
	@PostMapping("/sub/update")
	public ResponseEntity<ResponseStructure<Subject>> updateStudent(@RequestBody Subject subject) {

		return subService.updateSubject(subject);
	}

	@GetMapping("/sub/find/{id}")
	public ResponseEntity<ResponseStructure<Subject>> FindSubjectById(@PathVariable int id) {

		return subService.findById(id);
	}
	@GetMapping("/sub/all")
	public ResponseEntity<ResponseStructure<List<Subject>>> findallSubject() {
		return subService.findAll();
		
	}
	
	@DeleteMapping("/stu/delete/{id}")
	public ResponseEntity<ResponseStructure<Subject>> deleteSubjectById(@PathVariable int id) {

		return subService.deleteById(id);
	}

	
	
	
}












