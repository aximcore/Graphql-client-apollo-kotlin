package me.axim

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.*


fun main() = runBlocking {
    println("Run")

    val apolloClient = ApolloClient.builder()
        .serverUrl("https://countries.trevorblades.com")
        .build()

   val job = launch {
       val response = try {
           apolloClient.query(GetCountriesQuery()).toDeferred().await()
       } catch (e: ApolloException) {
           println(e)
           return@launch
       }

       val countries = response.data?.countries
       if (countries == null || response.hasErrors()) {
           println(response)
           return@launch
       }

       countries.forEach {
           println(it)
       }
   }

    job.join()

    val job2 = launch {
        val response = try {
            apolloClient.query(GetCountryByIsoCodeQuery("HU")).toDeferred().await()
        } catch (e: ApolloException) {
            println(e)
            return@launch
        }

        val country = response.data?.country
        if (country == null || response.hasErrors()) {
            println(response)
            return@launch
        }

        println("Country by code: $country")
    }

    job2.join()
}