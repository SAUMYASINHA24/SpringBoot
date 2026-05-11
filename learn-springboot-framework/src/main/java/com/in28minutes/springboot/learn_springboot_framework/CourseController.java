package com.in28minutes.springboot.learn_springboot_framework;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> getCourses()
	{
		return Arrays.asList(
				new Course(1,"JAVA","Udemy"),
				new Course(2,"Python","Coursera")
				);
	}

}
