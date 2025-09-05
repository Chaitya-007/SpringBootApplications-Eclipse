package com.code.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class DoctorsExceptionHandler {

	@ExceptionHandler(DoctorsException.class)
	public ResponseEntity<?> ResponseNotFounf(DoctorsException doctorsException, WebRequest webRequest){
		Errordetails errorDetails = new Errordetails(new Date(), doctorsException.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
