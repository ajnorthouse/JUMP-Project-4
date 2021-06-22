package com.cognixia.jumplus.project4.exception;

import java.util.Date;

/** Handles details of an error.
 * <p>
 * @param timestamp - time & date of error.
 * @param message - error message.
 * @param details - extra details.
 * <p>
 * @author	Alexandré Northouse
 * @version	1.0
 * @since	2020-06-22
 */

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
