package com.example.moengage.networking.response

/**
 * Created by Akshay Sharma on 14/05/23.
 */

data class NewsResponse(

    val status : String?,
    val articles : List<Article>?
)

data class Article(

    val source : Source?,
    val author : String?,
    val title : String?,
    val description : String?,
    val url : String?,
    val urlToImage : String?,
    val publishedAt : String?,
    val content : String?
)

data class Source(

    val id : String?,
    val name : String?
)

