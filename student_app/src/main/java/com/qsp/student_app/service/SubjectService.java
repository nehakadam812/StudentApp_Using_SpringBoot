package com.qsp.student_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qsp.student_app.dao.SubjectDao;
import com.qsp.student_app.dto.ResponseStructure;
import com.qsp.student_app.entity.Student2;
import com.qsp.student_app.entity.Subject;
import com.qsp.student_app.exception.StudentInvalidIdException;
import com.qsp.student_app.exception.StudentNullValueException;

@Service
public class SubjectService {
	@Autowired
	SubjectDao dao;
	
	
	public ResponseEntity<ResponseStructure<Subject>> saveSubject(Subject sub){
		
	
		Subject subject=dao.saveSubject(sub);
		ResponseStructure<Subject> stru=new ResponseStructure<Subject>();
		stru.setStatusCode(HttpStatus.CREATED.value());
		stru.setMessage("created");
		stru.setData(subject);
		return new ResponseEntity<ResponseStructure<Subject>>(stru,HttpStatus.CREATED);
		
		
		
	}
	
	public ResponseEntity<ResponseStructure<Subject>> updateSubject(Subject sub) {
		try {
			Subject subject = dao.saveSubject(sub);
			ResponseStructure<Subject> structure = new ResponseStructure<Subject>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("creted");
			structure.setData(subject);
			return new ResponseEntity<ResponseStructure<Subject>>(structure, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new StudentNullValueException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Subject>>> findAll() {
		List<Subject> list=dao.findAllSubject();
		ResponseStructure<List<Subject>> resp = new ResponseStructure<List<Subject>>();
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Found");
			resp.setData(list);
			
			return new ResponseEntity<ResponseStructure<List<Subject>>>(resp, HttpStatus.FOUND);
		
	}
	public ResponseEntity<ResponseStructure<Subject>> findById(int id) {
		Subject stu = dao.findSubjectById(id);
	
		if(stu!=null) {
			ResponseStructure<Subject> resp = new ResponseStructure<Subject>();
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Found");
			resp.setData(stu);
		
			return new ResponseEntity<ResponseStructure<Subject>>(resp, HttpStatus.FOUND);
			
		}else  {
			throw new StudentInvalidIdException();
		}
	}
	

	public ResponseEntity<ResponseStructure<Subject>> deleteById(int id) {
		Subject stu = dao.findSubjectById(id);
	
		if(stu!=null) {
			dao.deleteById(id);
			ResponseStructure<Subject> resp = new ResponseStructure<Subject>();
			resp.setStatusCode(HttpStatus.FOUND.value());
			resp.setMessage("Found");
			resp.setData(stu);
			System.out.println("hii");
			return new ResponseEntity<ResponseStructure<Subject>>(resp, HttpStatus.FOUND);
			
		}else  {
			throw new StudentInvalidIdException();
		}
	}
	

}
