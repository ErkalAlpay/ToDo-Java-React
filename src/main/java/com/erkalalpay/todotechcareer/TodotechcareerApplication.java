package com.erkalalpay.todotechcareer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class TodotechcareerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodotechcareerApplication.class, args);
	}

	@Bean
	public OpenAPI baseOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("Erkal To-Do API")
						.version("1.0.0").description("Doc Description")
						.license(new License().name("Alpay License")));
	}
}
