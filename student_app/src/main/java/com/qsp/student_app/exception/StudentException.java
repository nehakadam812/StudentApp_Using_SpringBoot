package com.qsp.student_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qsp.student_app.dto.ResponseStructure;

@ControllerAdvice
public class StudentException {

	@ExceptionHandler(StudentNullValueException.class)
	public ResponseEntity<ResponseStructure<String>> studentNullValue(StudentNullValueException exception) {

		ResponseStructure<String> stru = new ResponseStructure<String>();
		stru.setStatusCode(HttpStatus.BAD_REQUEST.value());
		stru.setMessage("Bad Request");
		stru.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(stru, HttpStatus.BAD_REQUEST);

	}
	

	@ExceptionHandler(StudentInvalidIdException.class)
	public ResponseEntity<ResponseStructure<String>> studentInvalidIdException(StudentInvalidIdException exception) {

		ResponseStructure<String> stru = new ResponseStructure<String>();
		stru.setStatusCode(HttpStatus.BAD_REQUEST.value());
		stru.setMessage("Bad Request");
		stru.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(stru, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(StudentPhoneNotValid.class)
	public ResponseEntity<ResponseStructure<String>> studentPhoneNotValid(StudentPhoneNotValid exception) {

		ResponseStructure<String> stru = new ResponseStructure<String>();
		stru.setStatusCode(HttpStatus.BAD_REQUEST.value());
		stru.setMessage("Bad Request");
		stru.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(stru, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(StudentEmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> studentEmailNotFound(StudentEmailNotFound exception) {

		ResponseStructure<String> stru = new ResponseStructure<String>();
		stru.setStatusCode(HttpStatus.BAD_REQUEST.value());
		stru.setMessage("Bad Request");
		stru.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(stru, HttpStatus.BAD_REQUEST);

	}

}
