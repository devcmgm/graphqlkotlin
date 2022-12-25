package com.example.demographql.mutation

import com.example.demographql.model.Demo
import com.example.demographql.service.DemoService
import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class DemoMutation: Mutation {

    @Autowired
    private lateinit var demoService: DemoService

    fun newDemo(someText: String): Mono<Demo> {
        return demoService.createNewDemo(someText)
    }

}
