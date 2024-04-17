package com.sample.fragmentexersice.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.fragmentexersice.model.Albums
import com.sample.fragmentexersice.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository {

    private var _postList = MutableLiveData<Albums?>()
    var postList: LiveData<Albums?> = _postList

    fun callPostApi() {
        val call = RetrofitInstance.apiService.getSpecificAlbums(3)
        call.enqueue(object : Callback<Albums> {
            override fun onResponse(p0: Call<Albums>, response: Response<Albums>) {
                if (response.isSuccessful) {
                    val post = response.body()
                    _postList.postValue(post)
                    Log.e("API Response", post.toString())
                }
            }

            override fun onFailure(p0: Call<Albums>, response: Throwable) {
                Log.e("API Response", response.message!!)
            }

        })
    }

}