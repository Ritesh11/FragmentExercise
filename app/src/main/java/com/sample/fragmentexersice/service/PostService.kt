package com.sample.fragmentexersice.service

import com.sample.fragmentexersice.model.Posts
import com.sample.fragmentexersice.model.PostsItem
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.GET


interface PostService {

    @GET("/posts")
    fun getPost(): Call<Posts>
}