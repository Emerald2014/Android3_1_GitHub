package com.example.android3_1_github.data

import com.example.android3_1_github.domain.entity.Repo
import com.example.android3_1_github.domain.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitClient {

    @GET("users")
    fun getUsers(): Single<List<User>>

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Single<List<Repo>>
}