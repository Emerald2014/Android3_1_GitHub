package com.example.android3_1_github.retrofit

import com.example.android3_1_github.data.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitClient {

    @GET("users")
    fun getUsers(): Call<List<User>>
}