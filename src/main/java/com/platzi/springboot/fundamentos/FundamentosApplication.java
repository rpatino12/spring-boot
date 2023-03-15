package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	// Here we are going to inject the dependency
	private ComponentDependency componentDependency;

	// Here we inject the dependency by the constructor with Spring Boot, we can use @Autowired but is not mandatory
	// If the dependency has many implementations, you have to select the implementation you want to use
	// Using the annotation @Qualifier we just select the component two implementation
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	// To execute the implementation of our dependency in the application
	// We have to implement the Spring Boot CommandLineRunner interface with the method run()
	@Override
	public void run(String... args) throws Exception {
		// And just call the method we want to use of the dependency
		componentDependency.sayHello();
	}
}
