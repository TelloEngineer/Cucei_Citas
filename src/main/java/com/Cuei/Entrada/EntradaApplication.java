package com.Cuei.Entrada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EntradaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntradaApplication.class, args);
	}

}
