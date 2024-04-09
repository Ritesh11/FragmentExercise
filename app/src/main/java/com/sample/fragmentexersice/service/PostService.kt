package com.sample.fragmentexersice.service

import com.sample.fragmentexersice.model.Posts
import retrofit2.Response
import retrofit2.http.GET


interface PostService {

    @GET("/posts")
    suspend fun getPost(): Response<Posts>
}