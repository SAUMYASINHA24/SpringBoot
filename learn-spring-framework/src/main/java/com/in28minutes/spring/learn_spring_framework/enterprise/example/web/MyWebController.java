package com.in28minutes.spring.learn_spring_framework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.spring.learn_spring_framework.enterprise.example.business.BusinessLayer;

@Component
public class MyWebController {
	
	@Autowired
	private BusinessLayer businessLayer;
	
	public MyWebController(BusinessLayer businessLayer) {
		super();
		System.out.println("business layer constructor called");
		this.businessLayer = businessLayer;
	}

	public int returnSum()
	{
		return businessLayer.calculateSum();
	}

}

