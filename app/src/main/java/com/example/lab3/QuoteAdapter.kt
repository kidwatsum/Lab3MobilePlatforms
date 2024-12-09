package com.example.lab3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Data.QuoteData

class QuoteAdapter(private val quotes:List<QuoteData>):RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    class QuoteViewHolder(view:View):RecyclerView.ViewHolder(view){
        val quoteText:TextView=view.findViewById(R.id.tvQuoteQuote)
        val authorText:TextView=view.findViewById(R.id.tvQuoteAuthor)
        fun bind(quote:QuoteData){
            quoteText.text=quote.quote
            authorText.text=quote.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.quote_list_item,parent,false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int=quotes.size

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote=quotes[position]
        /*holder.quoteText.text=quote.quote
        holder.authorText.text=quote.author*/
        holder.bind(quote)

        holder.itemView.setOnClickListener{
            val context=holder.itemView.context
            val intent=Intent(context,QuoteDetailsActivity::class.java).apply {
                putExtra("quote",quote.quote)
                putExtra("author",quote.author)
                putExtra("id",quote.id)
            }
            context.startActivity(intent)
        }
    }

}