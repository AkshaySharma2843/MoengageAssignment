package com.example.moengage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moengage.databinding.ActivityMainBinding
import com.example.moengage.networking.ApiCall
import com.example.moengage.networking.response.Article

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiCall = ApiCall()
        apiCall.getFact()

        //Observing the data in the view using the Live -Data
        apiCall.newsListLiveData.observe(this, Observer {
            setRecyclerView(it)
        })
    }

    private fun setRecyclerView(article: ArrayList<Article>?) {
        binding.recNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = article?.let { NewsAdapter(article) }
        }

    }
}