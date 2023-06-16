package com.example.traveguide.data.retrofit


import com.example.traveguide.data.response.HomeResponseItem
import com.example.traveguide.data.response.TipsResponseItem
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("tips")
    fun getTips(): Call<List<TipsResponseItem>>

    @GET("home")
    fun getHome(): Call<List<HomeResponseItem>>
}