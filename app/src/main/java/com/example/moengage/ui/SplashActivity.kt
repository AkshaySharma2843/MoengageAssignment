package com.example.moengage.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.moengage.databinding.ActivitySplashBinding


/**
 * Created by Akshay Sharma on 14/05/23.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding
    companion object {
        const val TAG = "SplashActivity"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mHandler = Handler()
        //Using Handler And Delaying the Intent Call so I can Go to Next Activity After Given Time
        mHandler.postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000L)

    }
}