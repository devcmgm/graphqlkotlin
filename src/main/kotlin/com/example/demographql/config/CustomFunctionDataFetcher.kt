package com.example.demographql.config

import com.expediagroup.graphql.execution.FunctionDataFetcher
import graphql.schema.DataFetchingEnvironment
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.reflect.KFunction

class CustomFunctionDataFetcher(target: Any?, fn: KFunction<*>) : FunctionDataFetcher(target, fn) {

    private fun convert(environment: DataFetchingEnvironment): Any? {
        return when (val result = super.get(environment)) {
            is Mono<*> -> result.toFuture()
            is Flux<*> -> result.collectList().toFuture()
            else -> result
        }
    }

    override fun get(environment: DataFetchingEnvironment): Any? {
        return convert(environment)
    }
}

