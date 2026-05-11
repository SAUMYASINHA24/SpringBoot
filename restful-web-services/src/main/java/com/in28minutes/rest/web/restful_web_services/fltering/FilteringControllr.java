package com.in28minutes.rest.web.restful_web_services.fltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class FilteringControllr {
	
	@GetMapping("/getUser")
	public SomeBean getUser()
	{
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/getUserWithList")
	public List<SomeBean> getUserWithList()
	{
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6")) ;
	}

	
	@GetMapping("/getUser/with-view")
	@JsonView(ViewClass.View1.class)
	public SomeBean getUserWithView()
	{
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/getUserWithList/list-with-view")
	@JsonView(ViewClass.View2.class)
	public List<SomeBean> getUserWithListView()
	{
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6")) ;
	}
}
