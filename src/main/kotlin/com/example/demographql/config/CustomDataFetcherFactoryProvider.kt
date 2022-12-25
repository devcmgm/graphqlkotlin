package com.example.demographql.config

import com.expediagroup.graphql.execution.SimpleKotlinDataFetcherFactoryProvider
import graphql.schema.DataFetcherFactory
import kotlin.reflect.KFunction

class CustomDataFetcherFactoryProvider(
) : SimpleKotlinDataFetcherFactoryProvider() {

    override fun functionDataFetcherFactory(target: Any?, kFunction: KFunction<*>): DataFetcherFactory<Any?> = DataFetcherFactory {
        CustomFunctionDataFetcher(
                target = target,
                fn = kFunction)
    }

}
