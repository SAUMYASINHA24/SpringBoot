package com.in28minutes.rest.web.restful_web_services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.web.restful_web_services.jpa.PostRepository;
import com.in28minutes.rest.web.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@RestController
public class UserJpaResource {
	
	/*public UserResource(UserDaoService daoService)
	{
		this.daoService = daoService;
	}*/
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path = "/jpa/getUsers")
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/jpa/getUsersById/{id}")
	public EntityModel<User> getAllUsers(@PathVariable int id)
	{
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty())
		{
			throw new UserNotFoundException("No match found for this id :"+id);
		}
		
		// HATEOAS IMPLEMENTATION TWO IMPORTANT THINGS EntityModel AND WEBMVCLINKBUILDER
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("delete-user"));
		entityModel.add(linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users")); // Multiple Linking
		return entityModel;
	}
	
	@PostMapping(path = "/jpa/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)
	{
		System.out.println(user.toString());
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping(path = "/jpa/deleteUser/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUserPosts(@PathVariable int id)
	{
		Optional<User> user = userRepository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("No match found for this id :"+id);
		
		return user.get().getPosts();
		
		
	}
	
	@PostMapping("/jpa/users/createPost/{id}")
	public ResponseEntity<Object> createUserPost(@PathVariable int id,@Valid @RequestBody Post post)
	{
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) throw new UserNotFoundException("No match found for this id :"+id);
		
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location ).build();
	}
	


}
