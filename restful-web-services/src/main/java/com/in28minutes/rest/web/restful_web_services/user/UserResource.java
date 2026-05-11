package com.in28minutes.rest.web.restful_web_services.user;

import java.net.URI;
import java.util.List;

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

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService daoService;
	
	/*public UserResource(UserDaoService daoService)
	{
		this.daoService = daoService;
	}*/
	
	@GetMapping(path = "/getUsers")
	public List<User> getAllUsers()
	{
		return daoService.findAll();
	}
	
	@GetMapping(path = "/getUsersById/{id}")
	public EntityModel<User> getAllUsers(@PathVariable int id)
	{
		User user = daoService.findUserById(id);
		if(user== null)
		{
			throw new UserNotFoundException("No match found for this id :"+id);
		}
		
		// HATEOAS IMPLEMENTATION TWO IMPORTANT THINGS EntityModel AND WEBMVCLINKBUILDER
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).deleteUser(id));
		entityModel.add(link.withRel("delete-user"));
		entityModel.add(linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users")); // Multiple Linking
		return entityModel;
	}
	
	@PostMapping(path = "/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user)
	{
		System.out.println(user.toString());
		User savedUser = daoService.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping(path = "/deleteUser/{id}")
	public List<User> deleteUser(@PathVariable int id)
	{
		List<User> finalUsers = daoService.deleteUserById(id);
		return finalUsers;
	}


}
