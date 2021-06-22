package com.cognixia.jumplus.project4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Example custom error for "Resource Not Found".
 * <p>
 * @author	Alexandré Northouse
 * @version	1.0
 * @since	2020-06-22
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}
