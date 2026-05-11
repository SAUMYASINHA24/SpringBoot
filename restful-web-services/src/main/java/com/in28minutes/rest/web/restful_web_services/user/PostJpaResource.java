package com.in28minutes.rest.web.restful_web_services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.web.restful_web_services.jpa.PostRepository;

@RestController
public class PostJpaResource {
	
	@Autowired
	private PostRepository postRepository;
	@GetMapping("/getPosts")
	public List<Post> getPosts()
	{
		return postRepository.findAll();
	}

}
