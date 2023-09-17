package com.erkalalpay.todotechcareer.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Erkal To-Do API")
                        .version("1.0.0").description("Doc Description")
                        .license(new License().name("Alpay License")));
    }


}
