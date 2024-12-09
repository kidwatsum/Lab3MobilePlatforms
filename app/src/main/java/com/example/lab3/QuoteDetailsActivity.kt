package com.example.lab3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuoteDetailsActivity:AppCompatActivity() {
    private lateinit var btnBack:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_details)

        val id=intent.getIntExtra("id",-1)
        val quote=intent.getStringExtra("quote")?:"No quote available"
        val author=intent.getStringExtra("author")?:"Unknown author"

        findViewById<TextView>(R.id.tvQuoteIdDetails).text="ID:$id"
        findViewById<TextView>(R.id.tvQuoteQuoteDetails).text=quote
        findViewById<TextView>(R.id.tvQuoteAuthorDetails).text=author

        btnBack=findViewById(R.id.btnGoBack)

        btnBack.setOnClickListener{
            val intent=Intent(this,QuoteListActivity::class.java)
            startActivity(intent)
        }
    }
}