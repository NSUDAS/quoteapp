package com.das.quotesapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.das.quotesapp.include.QuotesState
import com.das.quotesapp.models.BreedModelItem
import com.das.quotesapp.repository.BreedRepository
import com.das.quotesapp.utils.CommonFunction
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */

@HiltViewModel
class BreedViewModel @Inject constructor(
    private val repository: BreedRepository, @ApplicationContext private val context: Context
) : ViewModel() {
    private val _response: MutableStateFlow<QuotesState<BreedModelItem?>> =
        MutableStateFlow(QuotesState.Loading)
    val response: MutableStateFlow<QuotesState<BreedModelItem?>> = _response

    init {
        fetchBreedList()

    }

     fun fetchBreedList() {
        viewModelScope.launch {
            if (CommonFunction.isNetworkAvailable(context)) {
                try {
                    val response = repository.getBreedList().first()
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
