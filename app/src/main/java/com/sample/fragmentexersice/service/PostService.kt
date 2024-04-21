package com.sample.fragmentexersice.service

import com.sample.fragmentexersice.model.AlbumItem
import com.sample.fragmentexersice.model.Albums
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface PostService {

    @GET("/albums")
    fun getAlbums(): Call<Albums>
    @GET("/albums")
    fun getSpecificAlbums(@Query("userId") userId: Int): Call<Albums>
    // Path Parameter
    @GET("/albums/{id}")
    fun getAlbum(@Path(value = "id") id: Int): Call<AlbumItem>
    @POST("/albums")
    fun setAlbum(@Body album: AlbumItem): Call<Albums>

}