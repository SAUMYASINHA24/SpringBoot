package com.in28minutes.rest.web.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int counter = 0;
	
	static {
		users.add(new User(++counter, "saumya", LocalDate.now().minusYears(30)));
		users.add(new User(++counter, "piyush", LocalDate.now().minusYears(20)));
		users.add(new User(++counter, "papa", LocalDate.now().minusYears(40)));
	}
	
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User findUserById(int id)
	{
		for (User user : users) {
			if(user.getId()==id)
			{
				return user;
			}
		}
		return null;
	}
	
	public User createUser(User user)
	{
		user.setId(++counter);
		users.add(user);
		return user;
	}
	
	public List<User> deleteUserById(int id)
	{
		for (User user : users) {
			if(user.getId()==id)
			{
				users.remove(user);
			}
		}
		return users;
	}
}
