package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.bean.MyBean;
import com.platzi.springboot.fundamentos.bean.MyBeanProperties;
import com.platzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.platzi.springboot.fundamentos.component.ComponentDependency;
import com.platzi.springboot.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.pojo.UserPojo;
import com.platzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
	private UserRepository userRepository;

	// Here we inject the dependency by the constructor with Spring Boot, we can use @Autowired but is not mandatory
	// If the dependency has many implementations, you have to select the implementation you want to use
	// Using the annotation @Qualifier we just select the component two implementation
	public FundamentosApplication(
			@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanProperties myBeanProperties,
			UserPojo userPojo,
			UserRepository userRepository)
	{
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	// To execute the implementation of our dependency in the application
	// We have to implement the Spring Boot CommandLineRunner interface with the method run()
	@Override
	public void run(String... args) throws Exception {
		// firstExamples();
		saveUsersInDatabase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		/*
		LOGGER.info("\n\tUser search with findByUserEmail method: " +
				userRepository.findByUserEmail("paola@domain.com")
						.orElseThrow(()-> new RuntimeException("User not found with that email")));

		userRepository.findAndSort("M", Sort.by("id").descending())
				.forEach(user -> LOGGER.info("\n\tUser that name starts with M: " + user));

		userRepository.findByName("Marisol").forEach(user -> LOGGER.info("User with query method: \n" + user));

		LOGGER.info("User with query method findByEmailAndName: \n" +
				userRepository.findByEmailAndName("marco@domain.com", "Marco")
				.orElseThrow(() -> new RuntimeException("User searched by email and name not found")));

		userRepository.findByNameLike("%D%").forEach(user -> LOGGER.info("\n User findByNameLike method: " + user));

		userRepository.findByNameOrEmail(null, "karen@domain.com")
				.forEach(user -> LOGGER.info("\n User findByNameOrEmail method: " + user));
		*/

		userRepository.findByBirthdateBetween(
				LocalDate.of(2021, 3, 1),
				LocalDate.of(2021, 6, 20))
				.forEach(user -> LOGGER.info("\n User with date interval: " + user));

		userRepository.findByNameLikeOrderByIdDesc("%M%")
				.forEach(user -> LOGGER.info("\n\t User starts with M and ordered: " + user));

		userRepository.findByNameContainingOrderByIdDesc("ar")
				.forEach(user -> LOGGER.info("\n\t User contains 'ar' and ordered: " + user));

		userRepository.findByNameContainingAndBirthdateBetween(
				"i",
				LocalDate.of(2020, 3, 1),
				LocalDate.of(2021,9, 20))
				.forEach(user -> LOGGER.info("\n\t User contains 'i' and Birthdate between: " + user));

	}

	// Let's create a method to insert data to our user table in our database
	private void saveUsersInDatabase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Laura", "laura@domain.com", LocalDate.of(2021, 4, 10));
		User user10 = new User("Manuel", "manuel@domain.com", LocalDate.of(2021, 1, 8));
		User user11 = new User("Miguel", "miguel@domain.com", LocalDate.of(2021, 10, 3));
		User user12 = new User("David", "david@domain.com", LocalDate.of(2021, 3, 3));

		List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);

		// Before using this method you have to inject the userRepository interface to the application
		userList.stream().forEach(userRepository::save); // Here we generate all the users for our table
	}

	private void firstExamples(){
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
