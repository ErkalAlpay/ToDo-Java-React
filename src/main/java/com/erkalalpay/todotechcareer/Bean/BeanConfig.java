package com.erkalalpay.todotechcareer.Bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }
}
