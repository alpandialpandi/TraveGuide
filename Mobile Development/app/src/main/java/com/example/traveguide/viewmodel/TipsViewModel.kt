package com.example.traveguide.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.traveguide.data.response.TipsResponseItem
import com.example.traveguide.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipsViewModel() : ViewModel() {
    private val _listTips = MutableLiveData<List<TipsResponseItem>?>()
    val listTips: LiveData<List<TipsResponseItem>?> = _listTips

    fun getTips() {
        val client = ApiConfig.getApiServiceTips().getTips()
        client.enqueue(object : Callback<List<TipsResponseItem>> {
            override fun onResponse(
                call: Call<List<TipsResponseItem>>,
                response: Response<List<TipsResponseItem>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    Log.d("response_tips",  responseBody.toString())
                    if (responseBody != null) {
                        _listTips.value = responseBody
                    }
                }
            }
            override fun onFailure(call: Call<List<TipsResponseItem>>, t: Throwable) {

            }
        })
    }
}