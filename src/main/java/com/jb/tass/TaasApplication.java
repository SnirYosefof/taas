package com.jb.tass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaasApplication.class, args);
	}

}
