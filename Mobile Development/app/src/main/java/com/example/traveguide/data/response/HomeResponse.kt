package com.example.traveguide.data.response

import com.google.gson.annotations.SerializedName

data class HomeResponseItem(

	@field:SerializedName("city")
	val city: String,

	@field:SerializedName("rating")
	val rating: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("place")
	val place: String,

	@field:SerializedName("gambar")
	val gambar: String
)
