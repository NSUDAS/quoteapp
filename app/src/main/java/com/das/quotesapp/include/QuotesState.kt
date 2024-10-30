package com.das.quotesapp.include

/**
 * Created by S N Shekhar Das on 30/10/24.
 *
 */


sealed class QuotesState<out T> {
    data class Success<T>(val data: T) : QuotesState<T>()
    data class Error(val message: String) : QuotesState<Nothing>()
    object Loading : QuotesState<Nothing>()
}