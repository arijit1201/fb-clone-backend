package com.akagami.api;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.akagami.api.entity.PostEntity;
import com.akagami.api.repositories.PostEntityRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.akagami.api.repositories")
public class EmployeeApiApplication implements CommandLineRunner{

	@Autowired
	private PostEntityRepository repository;
	private static Logger log = Logger.getLogger(EmployeeApiApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiApplication.class, args);
		
			
	}
	
	@Override
	  public void run(String... args) throws Exception {
		log.info("---------------------------Server has started---------------------------");
//	    repository.deleteAll();
//
//	    // save a couple of customers
//	    repository.save(new EmployeeEntity("Alice", "Smith", "alicesmith@example.com"));
//	    repository.save(new EmployeeEntity("Bob", "Smith", "bobsmith@example.com"));
//
//	    // fetch all customers
//	    System.out.println("Customers found with findAll():");
//	    System.out.println("-------------------------------");
//	    for (EmployeeEntity customer : repository.findAll()) {
//	      System.out.println(customer);
//	    }
//	    System.out.println();
//
//	    // fetch an individual customer
//	    System.out.println("Customer found with findByFirstName('Alice'):");
//	    System.out.println("--------------------------------");
//	    System.out.println(repository.findByFirstName("Alice"));
//
//	    System.out.println("Customers found with findByLastName('Smith'):");
//	    System.out.println("--------------------------------");
//	    for (EmployeeEntity customer : repository.findByLastName("Smith")) {
//	      System.out.println(customer);
//	    }

	  }

}
