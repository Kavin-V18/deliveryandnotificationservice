package com.example.DeliveryNotificationModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DeliveryNotificationModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryNotificationModuleApplication.class, args);
	}

}

