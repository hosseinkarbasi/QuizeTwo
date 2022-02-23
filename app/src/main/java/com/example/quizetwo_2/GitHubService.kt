package com.example.quizetwo_2

import retrofit2.Call
import retrofit2.http.*
import searchimage.SearchImage

interface GitHubService {

    @POST("services/rest")
    fun getImage(
        @Query("api_key") apiKey: String,
        @Query("method") method: String,
        @Query("extras") extras: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String,
        @Query("per_page") per_page: String,
        @Query("page") page: String,
        ): Call<FlickrResult>

    @POST("services/rest")
    fun searchImage(
        @Query("api_key") apiKey: String,
        @Query("method") method: String,
        @Query("text") text: String,
        @Query("extras") extras: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String,
    ): Call<SearchImage>

}