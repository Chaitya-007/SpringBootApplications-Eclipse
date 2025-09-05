package com.code.exception;

//import java.security.Timestamp;
import java.util.Date;

public class ErrorDetail {
	private Date timestamp;
	private String details;
	private String message;

	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetail(Date timestamp, String details, String message) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getDetails() {
		return details;
	}

	public String getMessage() {
		return message;
	}

}
