package com.das.quotesapp.models

data class BreedModelItem(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val state_province: Any,
    val web_pages: List<String>
)