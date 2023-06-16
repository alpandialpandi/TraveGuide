package com.example.traveguide.data.response

import com.google.gson.annotations.SerializedName

data class TipsResponseItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("picture")
	val picture: String,

	@field:SerializedName("content")
	val content: String
)
