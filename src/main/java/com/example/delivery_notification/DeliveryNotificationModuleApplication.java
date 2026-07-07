package com.example.delivery_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeliveryNotificationModuleApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeliveryNotificationModuleApplication.class, args);
	}
}

