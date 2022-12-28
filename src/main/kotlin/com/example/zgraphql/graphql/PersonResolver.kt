package com.example.zgraphql.graphql
import com.example.zgraphql.graphql.api.PersonsQueryResolver
import com.example.zgraphql.graphql.model.Person

class PersonResolver() : PersonsQueryResolver
     {

    override fun persons(): List<com.example.zgraphql.graphql.model.Person> {
        val person1 = Person("id1","name1")
        val person2 = Person("id2","name2")
        return listOf<Person>(person1, person2)
    }
}