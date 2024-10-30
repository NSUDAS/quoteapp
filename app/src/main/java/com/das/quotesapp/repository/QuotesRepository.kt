package com.das.quotesapp.repository

import com.das.quotesapp.data.api.ApiService
import com.das.quotesapp.models.QuotesResult
import com.das.quotesapp.models.ResponseQuotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */
class QuotesRepository @Inject constructor(private val apiService: ApiService) {

    fun getQuotesRepo(): Flow<ResponseQuotes> = flow {
        val response = apiService.getListOfQuotes()
        emit(response)
    }.flowOn(Dispatchers.IO)

    fun getQuotesRandomRepo(): Flow<QuotesResult> = flow {
        val response = apiService.getRandomsQuotes()
        emit(response)
    }.flowOn(Dispatchers.IO)

}