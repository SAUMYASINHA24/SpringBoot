package com.in28minutes.rest.web.restful_web_services.exception;

import java.time.LocalDateTime;

public class ErrorHandler {
	
	private LocalDateTime errorDate;
	private String message;
	private String errorDescription;
	public ErrorHandler(LocalDateTime errorDate, String message, String errorDescription) {
		super();
		this.errorDate = errorDate;
		this.message = message;
		this.errorDescription = errorDescription;
	}
	public LocalDateTime getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(LocalDateTime errorDate) {
		this.errorDate = errorDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	@Override
	public String toString() {
		return "ErrorHandler [errorDate=" + errorDate + ", message=" + message + ", errorDescription="
				+ errorDescription + "]";
	}
	
	

}
