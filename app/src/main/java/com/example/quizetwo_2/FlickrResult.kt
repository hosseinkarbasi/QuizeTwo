package com.example.quizetwo_2

import com.google.gson.annotations.SerializedName

data class FlickrResult(
    @SerializedName("photos") val photos: Photos,
    val stat: String
)