package com.example.traveguide.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.traveguide.data.response.HomeResponseItem

import com.example.traveguide.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel() : ViewModel() {
    private val _listHome = MutableLiveData<List<HomeResponseItem>?>()
    val listHome: LiveData<List<HomeResponseItem>?> = _listHome

    fun getHome() {
        val client = ApiConfig.getApiServiceHome().getHome()
        client.enqueue(object : Callback<List<HomeResponseItem>> {
            override fun onResponse(
                call: Call<List<HomeResponseItem>>,
                response: Response<List<HomeResponseItem>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    Log.d("response_home",  responseBody.toString())
                    if (responseBody != null) {
                        _listHome.value = responseBody
                    }
                }
            }
            override fun onFailure(call: Call<List<HomeResponseItem>>, t: Throwable) {

            }
        })
    }
}