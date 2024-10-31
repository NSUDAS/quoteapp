package com.das.quotesapp.models

data class QuoteResponseModel(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)