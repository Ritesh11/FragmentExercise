package com.sample.fragmentexersice.retrofit

import com.google.gson.GsonBuilder
import com.sample.fragmentexersice.service.PostService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
    companion object{
        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

        val apiService: PostService by lazy {
            retrofit.create(PostService::class.java)
        }
    }
}