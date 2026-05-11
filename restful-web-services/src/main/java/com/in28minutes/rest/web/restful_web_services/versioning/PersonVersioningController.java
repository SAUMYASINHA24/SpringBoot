package com.in28minutes.rest.web.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	// Controller 1 and 2 are the examples of URL Versioning
	@GetMapping("/person/v1")
	public PersonV1 getNameVersion1()
	{
		return new PersonV1("Saumya Sinha");
	}
	
	@GetMapping("/person/v2")
	public PersonV2 getNameVersion2()
	{
		return new PersonV2(new Name("Saumya", "Sinha"));
	}
	
	// Controller 3 and 4 are the examples of Request Parameter Versioning
	
	@GetMapping(path = "/personRequestParam" ,params = "version=1")
	public PersonV1 getNameRequestParamVersion1()
	{
		return new PersonV1("Saumya Sinha");
	}
	
	@GetMapping(path = "/personRequestParam" ,params = "version=2")
	public PersonV2 getNameRequestParamVersion2()
	{
		return new PersonV2(new Name("Saumya", "Sinha"));
	}
	
	// Controller 5 and 6 are the examples of Header Versioning
	@GetMapping(path = "/personHeader" ,headers = "X-API-VERSION=1")
	public PersonV1 getNameHeaderVersion1()
	{
		return new PersonV1("Saumya Sinha");
	}
	
	@GetMapping(path = "/personHeader" ,headers = "X-API-VERSION=2")
	public PersonV2 getNameHeaderVersion2()
	{
		return new PersonV2(new Name("Saumya", "Sinha"));
	}
	
	// Controller 7 and 8 are the examples of Media Type Versioning
	@GetMapping(path = "/personAccept" ,produces = "application/vnd.comapny.app-v1+json")
	public PersonV1 getNameAcceptVersion1()
	{
		return new PersonV1("Saumya Sinha");
	}
	
	@GetMapping(path = "/personAccept" ,produces = "application/vnd.comapny.app-v2+json")
	public PersonV2 getNameAcceptVersion2()
	{
		return new PersonV2(new Name("Saumya", "Sinha"));
	}


}
