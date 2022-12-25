package com.example.demographql

import com.example.demographql.config.CustomDataFetcherFactoryProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class demographqlApplication

fun main(args: Array<String>) {
	runApplication<demographqlApplication>(*args)
}
