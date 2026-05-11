package com.in28minutes.rest.web.restful_web_services.helloworld;

import org.springframework.stereotype.Component;

public class HelloWorldBean {
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HelloWorldBean(String message) {
		
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
