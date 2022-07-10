package com.cognizant.authorizationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.authorizationService.Repository.UserRepository;
import com.cognizant.authorizationService.model.MyUser; 


/**
 * @author Sohit Sen
 *
 */
@SpringBootApplication
public class JwtAuthenticationApplication {
	

	@Autowired
    private UserRepository repository;
	
	/**
	 * 
	 * Command Line Runner for the registered user's
	 * 
	 * 
	 */
	
    @PostConstruct
    public void initUsers() {
        List<MyUser> users = Stream.of(
               new MyUser("1","Sohit","Sohit"),
               new MyUser("2","Krati","Krati"),
               new MyUser("3","Rashmita","Rashmita"),
               new MyUser("4","Akanksha","Akanksha"),
               new MyUser("5","admin","admin")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
    
    /**
	 *SpringBoot main method that launches the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
		
	}

}
