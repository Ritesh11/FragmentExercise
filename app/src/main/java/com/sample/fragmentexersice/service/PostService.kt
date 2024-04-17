package com.sample.fragmentexersice.service

import com.sample.fragmentexersice.model.Albums
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PostService {

    @GET("/albums")
    fun getAlbums(): Call<Albums>
    @GET("/albums")
    fun getSpecificAlbums(@Query("userId") userId: Int): Call<Albums>

}