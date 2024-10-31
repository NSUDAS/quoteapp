package com.das.quotesapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.das.quotesapp.include.QuotesState
import com.das.quotesapp.models.QuoteResponseModel
import com.das.quotesapp.repository.BreedRepository
import com.das.quotesapp.repository.QuotesRadmonRepository
import com.das.quotesapp.utils.CommonFunction
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */

@HiltViewModel
class QuotesRandmonViewModel @Inject constructor(
    private val repository: QuotesRadmonRepository, @ApplicationContext private val context: Context
) : ViewModel() {
    private val _response: MutableStateFlow<QuotesState<QuoteResponseModel?>> =
        MutableStateFlow(QuotesState.Loading)
    val response: MutableStateFlow<QuotesState<QuoteResponseModel?>> = _response

    init {
        fetchAllQuotesList()

    }

    fun fetchAllQuotesList() {
        viewModelScope.launch {
            if (CommonFunction.isNetworkAvailable(context)) {
                try {
                    val response = repository.getAllList().first()
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
}
