package com.qsp.student_app.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.student_app.dao.StudentDao;
import com.qsp.student_app.dto.ResponseStructure;
import com.qsp.student_app.entity.Student2;
import com.qsp.student_app.exception.StudentEmailNotFound;
import com.qsp.student_app.exception.StudentInvalidIdException;
import com.qsp.student_app.exception.StudentNullValueException;
import com.qsp.student_app.exception.StudentPhoneNotValid;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseEntity<ResponseStructure<Student2>> saveStudent(Student2 stu) {
		try {
			Student2 student = dao.saveStudent(stu);
			ResponseStructure<Student2> structure = new ResponseStructure<Student2>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("created");
			structure.setData(student);

			return new ResponseEntity<ResponseStructure<Student2>>(structure, HttpStatus.CREATED);

		} catch (Exception e) {
			throw new StudentNullValueException();
		}
	}
public ResponseEntity<ResponseStructure<List<Student2>>> findAll(){
	List list=dao.findAllStudent();
	ResponseStructure<List<Student2>> structure = new ResponseStructure<List<Student2>>();
	structure.setStatusCode(HttpStatus.CREATED.value());
	structure.setMessage("created");
	structure.setData(list);

	return new ResponseEntity<ResponseStructure<List<Student2>>>(structure, HttpStatus.CREATED);
	
	
	
}
	public ResponseEntity<ResponseStructure<Student2>> updateStudent(Student2 stu) {
		try {
			Student2 student = dao.saveStudent(stu);
			ResponseStructure<Student2> structure = new ResponseStructure<Student2>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("creted");
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student2>>(structure, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new StudentNullValueException();
		}
	}

	public ResponseEntity<ResponseStructure<Student2>> findById(int id) {
		Student2 stu = dao.findStudentById(id);
	
		if(stu!=null) {
			ResponseStructure<Student2> resp = new ResponseStructure<Student2>();
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Found");
			resp.setData(stu);
			System.out.println("hii");
			return new ResponseEntity<ResponseStructure<Student2>>(resp, HttpStatus.FOUND);
			
		}else  {
			throw new StudentInvalidIdException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Student2>> findByPhone(long phone) {
		Student2 stu = dao.findbyStudentPhone(phone);
	
		if(stu!=null) {
			ResponseStructure<Student2> resp = new ResponseStructure<Student2>();
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Found");
			resp.setData(stu);
			System.out.println("hii");
			return new ResponseEntity<ResponseStructure<Student2>>(resp, HttpStatus.FOUND);
			
		}else  {
			throw new StudentPhoneNotValid();
		}
	}
	public ResponseEntity<ResponseStructure<Student2>> findByEmail(String email) {
		Student2 stu = dao.findbyStudentEmail(email);
	
		if(stu!=null) {
			ResponseStructure<Student2> resp = new ResponseStructure<Student2>();
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Found");
			resp.setData(stu);
			System.out.println("hii");
			return new ResponseEntity<ResponseStructure<Student2>>(resp, HttpStatus.FOUND);
			
		}else  {
			throw new StudentEmailNotFound();
		}
	}
	public ResponseEntity<ResponseStructure<Student2>> deleteById(int id) {
		Student2 stu = dao.findStudentById(id);
	
		if(stu!=null) {
			dao.deleteStudentById(id);
			ResponseStructure<Student2> resp = new ResponseStructure<Student2>();
			resp.setStatusCode(HttpStatus.OK.value());
			resp.setMessage("Deleted");
			resp.setData(stu);
			System.out.println("hii");
			return new ResponseEntity<ResponseStructure<Student2>>(resp, HttpStatus.OK);
			
		}else  {
			throw new StudentInvalidIdException();
		}
		
		
		
	}
	

	

}
