package com.das.quotesapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.das.quotesapp.include.QuotesState
import com.das.quotesapp.models.QuotesResult
import com.das.quotesapp.models.ResponseQuotes
import com.das.quotesapp.repository.QuotesRepository
import com.das.quotesapp.utils.CommonFunction.isNetworkAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by S N Shekhar Das on 30/10/24.
 * upay (UCB Fintech Company Limited)
 */

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val repository: QuotesRepository, @ApplicationContext private val context: Context
) : ViewModel() {

    private val _response: MutableStateFlow<QuotesState<ResponseQuotes?>> =
        MutableStateFlow(QuotesState.Loading)
    val response: MutableStateFlow<QuotesState<ResponseQuotes?>> = _response

    private val responseRandmonQuotes: MutableStateFlow<QuotesState<QuotesResult?>> =
        MutableStateFlow(QuotesState.Loading)
    val randomQuotesResponse: MutableStateFlow<QuotesState<QuotesResult?>> =
        responseRandmonQuotes

    init {
        fetchQuotes()
        fetchRandomQuotes()
    }

    private fun fetchQuotes() {
        viewModelScope.launch {
            if (isNetworkAvailable(context)) {
                try {
                    val response = repository.getQuotesRepo().first()
                    _response.emit(QuotesState.Success(response))

                } catch (e: Exception) {
                    val errorMessage = "An Error occurred. Please try again"
                    _response.emit(QuotesState.Error(errorMessage))
                }
            } else {
                _response.emit(QuotesState.Error("No internet connection"))
            }
        }
    }

    fun fetchRandomQuotes() {
        viewModelScope.launch {
            if (isNetworkAvailable(context)) {
                try {
                    val response = repository.getQuotesRandomRepo().first()
                    responseRandmonQuotes.emit(QuotesState.Success(response))

                } catch (e: Exception) {
                    val errorMessage = "An Error occurred. Please try again"
                    responseRandmonQuotes.emit(QuotesState.Error(errorMessage))
                }
            } else {
                _response.emit(QuotesState.Error("No internet connection"))
            }
        }
    }
}