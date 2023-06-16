package com.example.traveguide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traveguide.adapter.HomeAdapter
import com.example.traveguide.databinding.ActivityHomeBinding
import com.example.traveguide.viewmodel.HomeViewModel

class Home : AppCompatActivity() {
    companion object {
        private val TAG = Home::class.java.simpleName
    }
    private lateinit var binding: ActivityHomeBinding

    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeViewModel.getHome()
        homeViewModel.listHome.observe(this){
            Log.d("listHome", it.toString())
            binding.listHome.layoutManager = LinearLayoutManager(this)
            val adapter = HomeAdapter(it)
            binding.listHome.adapter = adapter
        }
        binding.ivTips.setOnClickListener {
            val intent = Intent(this, Tips::class.java)
            startActivity(intent)
        }
        binding.ivLogout.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}