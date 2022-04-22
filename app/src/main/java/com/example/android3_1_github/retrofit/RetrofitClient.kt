package com.example.android3_1_github.retrofit

import com.example.android3_1_github.data.Repo
import com.example.android3_1_github.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitClient {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<Repo>>
}