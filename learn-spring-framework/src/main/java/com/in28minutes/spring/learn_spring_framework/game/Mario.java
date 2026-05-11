package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Mario implements GamingConsole{
	
	public void up()
	{
		System.out.println("up");
	}
	
	public void down()
	{
		System.out.println("down");
	}
	
	public void left()
	{
		System.out.println("left");
	}
	
	public void right()
	{
		System.out.println("right");
	}

}
