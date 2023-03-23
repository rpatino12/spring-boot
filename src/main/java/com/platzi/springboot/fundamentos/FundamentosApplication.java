package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.bean.MyBean;
import com.platzi.springboot.fundamentos.bean.MyBeanProperties;
import com.platzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.platzi.springboot.fundamentos.component.ComponentDependency;
import com.platzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	// We can use the Apache Commons library to use our logs, so we just add a Logger attribute
	private final Log LOGGER  = LogFactory.getLog(FundamentosApplication.class);

	// Here we are going to inject the dependency
	private ComponentDependency componentDependency;
	// Let's inject another dependencies
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanProperties myBeanProperties;
	private UserPojo userPojo;

	// Here we inject the dependency by the constructor with Spring Boot, we can use @Autowired but is not mandatory
	// If the dependency has many implementations, you have to select the implementation you want to use
	// Using the annotation @Qualifier we just select the component two implementation
	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanProperties myBeanProperties,
			UserPojo userPojo)
	{
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
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
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanProperties.showProperties());
		System.out.println(userPojo.toString());

		try{
			int operation = 10/0;
		} catch (Exception e){
			LOGGER.error("This is our error log, " + e.getMessage());
		}
	}
}
