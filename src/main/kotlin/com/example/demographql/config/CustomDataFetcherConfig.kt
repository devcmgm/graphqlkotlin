package com.example.demographql.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomDataFetcherConfig {
    @Bean
    fun dataFetcherFactoryProvider() = CustomDataFetcherFactoryProvider()
}
