package com.example.demographql.model

import com.expediagroup.graphql.annotations.GraphQLID
import org.springframework.data.annotation.Id
import java.util.*

data class Demo(
        val someText: String
) {
    @GraphQLID @Id
    var id: String = UUID.randomUUID().toString()
}
