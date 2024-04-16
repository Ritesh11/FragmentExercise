package com.sample.fragmentexersice.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.sample.fragmentexersice.model.Posts
import com.sample.fragmentexersice.retrofit.RetrofitInstance
import com.sample.fragmentexersice.service.PostService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class PostRepository {

    private var _postList = MutableLiveData<Posts?>()
    var postList: LiveData<Posts?> = _postList

     fun callPostApi() {

             val call = RetrofitInstance.apiService.getPost()
             call.enqueue(object : Callback<Posts> {
                 override fun onResponse(p0: Call<Posts>, response: Response<Posts>) {
                     if (response.isSuccessful) {
                         val post = response.body()
                         _postList.postValue(post)
                         Log.e("API Response", post.toString())
                     }
                 }

                 override fun onFailure(p0: Call<Posts>, p1: Throwable) {
                     TODO("Not yet implemented")
                 }

             })
         }



}