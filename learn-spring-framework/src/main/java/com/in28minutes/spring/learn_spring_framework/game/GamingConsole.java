package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public interface GamingConsole {
	
	void up();
	void down();
	void left();
	void right();

}
