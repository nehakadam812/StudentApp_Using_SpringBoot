package com.qsp.student_app.exception;

public class StudentEmailNotFound extends RuntimeException{
	@Override
	public String getMessage() {
		return "Given Email is not present";
		
	}
}
