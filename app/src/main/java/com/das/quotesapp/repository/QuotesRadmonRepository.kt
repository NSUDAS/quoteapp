package com.das.quotesapp.repository

import com.das.quotesapp.data.api.ApiService
import com.das.quotesapp.models.QuoteResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */
class QuotesRadmonRepository @Inject constructor(private val apiService: ApiService) {
    fun getAllList(): Flow<QuoteResponseModel> = flow {
        val response = apiService.getAllQuotes()
        emit(response)
    }.flowOn(Dispatchers.IO)
}