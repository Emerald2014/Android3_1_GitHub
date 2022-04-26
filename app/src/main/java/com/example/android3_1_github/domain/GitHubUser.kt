package com.example.android3_1_github.domain

import com.example.android3_1_github.domain.entity.User
import io.reactivex.rxjava3.core.Single

interface GitHubUser {
    fun getUsersGitHub(): Single<List<User>>
}