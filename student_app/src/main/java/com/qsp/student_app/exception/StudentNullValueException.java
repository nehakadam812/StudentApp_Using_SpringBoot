package com.qsp.student_app.exception;

public class StudentNullValueException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "don't assign null value for phone or email";
		
	}

}
