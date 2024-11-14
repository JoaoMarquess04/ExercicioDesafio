package com.example.springboot.dtos;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    // Definindo o ModelMapper como um bean para injeção automática
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
