package com.qsp.student_app.exception;

public class StudentInvalidIdException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "Enter valid id";
		
	}

}
