package com.example.demographql.repository

import com.example.demographql.model.Demo
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DemoRepository: ReactiveMongoRepository<Demo, String> {
}
