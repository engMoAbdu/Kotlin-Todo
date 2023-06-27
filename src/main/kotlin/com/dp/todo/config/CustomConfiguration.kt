package com.dp.todo.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomConfiguration {

    @Bean
    fun modelMapper(): ModelMapper {
        val modelMapper = ModelMapper()
        return modelMapper
    }
}