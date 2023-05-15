package com.example.moengage.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moengage.databinding.ItemViewNewsBinding
import com.example.moengage.networking.response.Article

/**
 * Created by Akshay Sharma on 13/05/23.
 */

class NewsAdapter(private val arrayList : ArrayList<Article>) : RecyclerView.Adapter<NewsViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ItemViewNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val arrayList : Article = arrayList[position]
        holder.bindData(arrayList,position)
    }
}