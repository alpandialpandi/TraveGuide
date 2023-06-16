package com.example.traveguide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traveguide.R
import com.example.traveguide.databinding.ActivityLoginBinding
import com.example.traveguide.databinding.ActivityReviewBinding

class Review : AppCompatActivity() {
    private lateinit var binding: ActivityReviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        binding = ActivityReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}