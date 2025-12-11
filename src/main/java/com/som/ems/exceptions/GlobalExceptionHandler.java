package com.som.ems.exceptions;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.som.ems.dto.ErrorResponseDto;
import com.som.ems.utility.Constants;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(EmployeeIdNotFoundException ex) {

		List<String> details = new ArrayList<>();
		details.add("Error : Employee Id not found");
		details.add("Detailed Message:" + ex.getLocalizedMessage());
		details.add("Timestamp:" + System.currentTimeMillis());
		ErrorResponseDto error = new ErrorResponseDto(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILURE,
				"NOT-FOUND", details);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
}
