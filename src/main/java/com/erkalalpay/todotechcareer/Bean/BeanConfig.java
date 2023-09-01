package com.erkalalpay.todotechcareer.Bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }


}
