package com.company.spring_data_rest_api.spring_data_rest;

import com.company.spring_data_rest_api.spring_data_rest.entity.User;
import com.company.spring_data_rest_api.spring_data_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		//create user and repository save method to save the user
		User user = User.builder()
				.firstName("deo")
				.middleName("deepak")
				.lastName("kumar")
				.email("deo.kumar@gmail.com")
				.build();
		userRepository.save(user);
		//create user and repository save method to save the user
		User user1 = User.builder()
				.firstName("suraj")
				.middleName("deo")
				.lastName("kumar")
				.email("suraj.kumar@gmail.com")
				.build();
		userRepository.save(user1);
		//create user and repository save method to save the user
		User user2 = User.builder()
				.firstName("tuntun")
				.middleName("aadi")
				.lastName("kumar")
				.email("deo.kumar@gmail.com")
				.build();
		userRepository.save(user2);

//GET method, url http://localhost:8080/api/v1/users use bruno/postman
	}
}
