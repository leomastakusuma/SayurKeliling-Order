package com.example.ESayurTransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ESayurTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESayurTransactionApplication.class, args);
	}

}
