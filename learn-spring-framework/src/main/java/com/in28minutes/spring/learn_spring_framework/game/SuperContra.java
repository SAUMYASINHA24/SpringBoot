package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContra implements GamingConsole{
	
	public void up()
	{
		System.out.println(" SuperContraup");
	}
	
	public void down()
	{
		System.out.println(" SuperContradown");
	}
	
	public void left()
	{
		System.out.println("SuperContraleft");
	}
	
	public void right()
	{
		System.out.println(" SuperContra right");
	}

}
