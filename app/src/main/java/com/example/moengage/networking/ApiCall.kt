package com.example.moengage.networking

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moengage.networking.response.Article
import com.example.moengage.networking.response.NewsResponse
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by Akshay Sharma on 13/05/23.
 */
class ApiCall {
    val URL = "https://candidate-test-data-moengage.s3.amazonaws.com/Android/news-api-feed/staticResponse.json"

    val TAG = "API_RESPONSE"

    //Live-data to observe arraylist in view or activity
    private val _newsListLiveData = MutableLiveData<ArrayList<Article>>()
    val newsListLiveData = _newsListLiveData

    fun getFact() {
        //To change the thread so the network call does not block the main thread
        Thread(Runnable {

            val connection = URL(URL).openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("Accept", "application/json")
            connection.connectTimeout = 10000
            connection.readTimeout = 10000
            connection.doInput = true

            try {
                val reader = InputStreamReader(connection.inputStream)

                reader.use { input ->
                    //To change the String Json into Gson response
                    val gson = Gson()
                    val newsResponse: NewsResponse = gson.fromJson(input, NewsResponse::class.java)
                    val arrayList = ArrayList<Article>()
                    newsResponse.articles?.let { arrayList.addAll(it) }
                    _newsListLiveData.postValue(arrayList)

                }

            }catch (e : Exception){
                Log.d(TAG,"In_Error ${e.localizedMessage}")

            }

            //To disconnect the HTTP URL connection
            connection.disconnect()

        }).start()


    }
}