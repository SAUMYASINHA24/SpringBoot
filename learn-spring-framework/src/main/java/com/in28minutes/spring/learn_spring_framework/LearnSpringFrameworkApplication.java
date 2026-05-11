package com.in28minutes.spring.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.spring.learn_spring_framework.enterprise.example.web.MyWebController;
import com.in28minutes.spring.learn_spring_framework.game.GameRunner;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, 
				args);
		//Mario game = new Mario();	// Tight Coupling
		//SuperContra game = new SuperContra();
		//PacMan game = new PacMan();
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnSum());
	}

}
