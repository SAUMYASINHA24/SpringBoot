package com.in28minutes.spring.learn_spring_framework.enterprise.example.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.spring.learn_spring_framework.enterprise.example.data.DataLayer;

@Component
public class BusinessLayer{
	
	//@Autowired
	private DataLayer dataLayer; // field Dependency injection type

	@Autowired
	public void setDataLayer(DataLayer dataLayer) {
		System.out.println("setter called");
		this.dataLayer = dataLayer;
	}


	public int calculateSum()
	{
		List<Integer>originalData = dataLayer.getData();
		return originalData.stream().reduce(Integer::sum).get();
	}
}

