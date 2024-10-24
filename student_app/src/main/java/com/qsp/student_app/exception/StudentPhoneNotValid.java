package com.qsp.student_app.exception;

public class StudentPhoneNotValid  extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "Given Phone number is not present";
		
	}

}
