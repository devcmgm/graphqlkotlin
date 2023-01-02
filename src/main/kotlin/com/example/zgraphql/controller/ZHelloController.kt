package com.example.zgraphql.controller

import com.example.zgraphql.db.HelloDto
import com.example.zgraphql.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ZHelloController(val helloService: HelloService) {

    @GetMapping("/zhello")
    fun helloKotlin(): String {
        return "hello world"
    }

    @GetMapping("/zhello-service")
    fun helloKotlinService(): String {
        return helloService.getHello()
    }

    @GetMapping("/zhello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("Hello from the dto")
    }
}