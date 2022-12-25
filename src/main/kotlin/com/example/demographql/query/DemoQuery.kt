package com.example.demographql.query

import com.example.demographql.model.Demo
import com.example.demographql.service.DemoService
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import reactor.core.publisher.Mono

@Controller
class DemoQuery: Query {

    @Autowired
    private lateinit var demoService: DemoService

    fun demo(id: String): Mono<Demo> {
        return demoService.findById(id)
    }

}
