package com.das.quotesapp.repository

import com.das.quotesapp.data.api.ApiService
import com.das.quotesapp.models.BreedModelItem
import com.das.quotesapp.models.QuoteResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */
class BreedRepository @Inject constructor(private val apiService: ApiService) {
    fun getBreedList(): Flow<BreedModelItem> = flow {
        val response = apiService.getBreedList()
        emit(response)
    }.flowOn(Dispatchers.IO)
}