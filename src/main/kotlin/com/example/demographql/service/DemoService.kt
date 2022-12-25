package com.example.demographql.service

import com.example.demographql.model.Demo
import com.example.demographql.repository.DemoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DemoService(val demoRepository: DemoRepository) {

    fun createNewDemo(someText: String): Mono<Demo> {
        val model = Demo(someText = someText)
        return demoRepository.save(model)
    }

    fun findById(demoId: String): Mono<Demo> {
        return demoRepository.findById(demoId)
    }

}
