package com.example.traveguide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.traveguide.databinding.ActivityTipsBinding
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traveguide.adapter.TipsAdapter
import com.example.traveguide.viewmodel.TipsViewModel

class Tips : AppCompatActivity() {
    companion object {
        private val TAG = Tips::class.java.simpleName
    }
    private lateinit var binding: ActivityTipsBinding

    private val tipsViewModel by viewModels<TipsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tipsViewModel.getTips()
        tipsViewModel.listTips.observe(this){
            Log.d("listTips", it.toString())
            binding.listTips.layoutManager = LinearLayoutManager(this)
            val adapter = TipsAdapter(it)
            binding.listTips.adapter = adapter
        }
        binding.ivBack.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}
