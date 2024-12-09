package com.example.lab3.API

import com.example.lab3.Data.QuoteData
import com.example.lab3.Data.QuoteResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiService {
    @GET("quotes")
    suspend fun getQuotes():Response<QuoteResponse>

}