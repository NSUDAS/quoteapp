package com.das.quotesapp.data.api

import com.das.quotesapp.data.api.Constants.Companion.BREED_LIST
import com.das.quotesapp.data.api.Constants.Companion.LIST_OF_QUOTES
import com.das.quotesapp.data.api.Constants.Companion.RANDOM_QUOTES
import com.das.quotesapp.models.BreedModelItem
import com.das.quotesapp.models.QuotesResult
import com.das.quotesapp.models.ResponseQuotes
import retrofit2.http.GET

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */
interface ApiService {

    @GET(LIST_OF_QUOTES)
    suspend fun getListOfQuotes() : ResponseQuotes

    @GET(RANDOM_QUOTES)
    suspend fun getRandomsQuotes() : QuotesResult

    @GET(BREED_LIST)
    suspend fun getBreedList() : BreedModelItem



}