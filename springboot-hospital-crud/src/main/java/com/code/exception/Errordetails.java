package com.code.exception;

import java.util.Date;

public class Errordetails {

	private Date timepStamp;
	private String description;
	private String message;
	public Errordetails(Date timepStamp, String description, String message) {
		super();
		this.timepStamp = timepStamp;
		this.description = description;
		this.message = message;
	}
	public Errordetails() {
		super();
	}
	public Date getTimepStamp() {
		return timepStamp;
	}
	public void setTimepStamp(Date timepStamp) {
		this.timepStamp = timepStamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

