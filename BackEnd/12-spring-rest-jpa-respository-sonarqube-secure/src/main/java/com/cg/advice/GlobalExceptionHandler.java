package com.cg.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.dto.ApiError;
import com.cg.exception.ApplicationExeption;
//Like a Catch block
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<ApiError> handle(Exception e) {
		ApiError error=new ApiError();
		error.setMsg(e.getMessage());
		error.setStatus(404);
		//return error;
		return new ResponseEntity<ApiError>(error,
				HttpStatusCode.valueOf(404));
	}
}
