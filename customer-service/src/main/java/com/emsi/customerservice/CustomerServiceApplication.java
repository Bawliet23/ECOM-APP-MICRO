package com.emsi.customerservice;

import com.emsi.customerservice.entities.Customer;
import com.emsi.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("BHAJY").email("BHAJY1@gmail.com").build(),
                            Customer.builder().name("BHAJY23").email("BHAJY2@gmail.com").build(),
                            Customer.builder().name("BHAJY1").email("BHAJY3@gmail.com").build()
                    )
            );

            customerRepository.findAll().forEach(c -> System.out.println(c));
        };
    }

}
