package com.example.traveguide.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traveguide.R
import com.example.traveguide.databinding.ActivityLoginBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}