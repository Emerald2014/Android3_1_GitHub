package com.example.android3_1_github.data

import com.example.android3_1_github.domain.GitHubRepo
import com.example.android3_1_github.domain.GitHubUser
import com.example.android3_1_github.domain.entity.Repo
import com.example.android3_1_github.domain.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GitHubImpl : GitHubUser, GitHubRepo {
    private val baseUrl = "https://api.github.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(RetrofitClient::class.java)

    override fun getUsersGitHub(): Single<List<User>> {
        return api.getUsers()
    }

    override fun getRepoGitHub(user: String): Single<List<Repo>> {
        return api.getRepos(user)
    }
}