package com.example.lab3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.API.QuoteApiService
import com.example.lab3.Data.QuoteData
import com.example.lab3.Network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteListActivity:AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter:QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quotes_fragment)

        recyclerView=findViewById(R.id.rvQuotes_List)
        recyclerView.layoutManager=LinearLayoutManager(this)

        adapter= QuoteAdapter(emptyList())
        recyclerView.adapter=adapter

        fetchQuotes()
    }

    fun fetchQuotes(){
        val apiService=RetrofitClient.retrofit.create(QuoteApiService::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response=apiService.getQuotes()
                if (response.isSuccessful){
                    val quoteResponse=response.body()
                    val quotes=quoteResponse?.quotes?: emptyList()

                    val adapter=QuoteAdapter(quotes)
                    recyclerView.adapter=adapter
                }else{
                    Log.e("API_ERROR", "Error: ${response.code()} - ${response.message()}")
                }
            }catch (e:Exception){
                Log.e("API_ERROR", "Exception: ${e.message}")
            }
        }


    }
}