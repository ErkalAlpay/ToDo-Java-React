package com.erkalalpay.todotechcareer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TodotechcareerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodotechcareerApplication.class, args);
	}

}
