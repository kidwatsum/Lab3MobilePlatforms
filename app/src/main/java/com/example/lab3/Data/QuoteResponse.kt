package com.example.lab3.Data

data class QuoteResponse(
    val quotes:List<QuoteData>,
    val total:Int,
    val skip:Int,
    val limit:Int
)
