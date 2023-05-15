package com.example.moengage.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moengage.databinding.ItemViewNewsBinding
import com.example.moengage.networking.response.Article

/**
* Created by Akshay Sharma on 13/05/23.
 *
*/

class NewsViewHolder(private val binding : ItemViewNewsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindData(article: Article, position: Int) {

        binding.tvAurthorName.text = article.title
        Glide
            .with(itemView)
            .load(article.urlToImage)
            .into(binding.ivImage)


    }

}