package com.cognixia.jumplus.project4.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/** Handles any errors that the API might throw.
 * <p>
 * @author	Alexandré Northouse
 * @version	1.0
 * @since	2020-06-22
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	/** Example handler for ResourceNotFoundException */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> carNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/** Generic exception handling */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}