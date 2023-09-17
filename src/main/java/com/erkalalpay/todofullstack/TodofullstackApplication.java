package com.erkalalpay.todofullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TodofullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodofullstackApplication.class, args);
	}


}
