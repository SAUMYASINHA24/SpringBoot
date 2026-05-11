package com.in28minutes.rest.web.restful_web_services.helloworld;

import java.util.Locale;

import org.jspecify.annotations.Nullable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}
	//@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	//@RequestMapping("/hello-world")
	@GetMapping("/hello-world")
	public String printHelloWorld()
	{
		return "Hello world! I am Saumya Sinha. I am learning Microservice";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean returnHelloWorldBean()
	{
		return new HelloWorldBean("Hello world! I am Saumya Sinha. I am learning Microservice");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean returnHelloWorldPathVar(@PathVariable String name)
	{
		return new HelloWorldBean("Hello world! I am "+name+" I am learning Microservice");
	}
	
	@GetMapping("/hello-world-internalization")
	public String printHelloWorldInternalization()
	{
		@Nullable
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
	}
	

}
