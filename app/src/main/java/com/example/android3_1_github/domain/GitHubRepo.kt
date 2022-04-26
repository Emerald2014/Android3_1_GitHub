package com.example.android3_1_github.domain

import com.example.android3_1_github.domain.entity.Repo
import io.reactivex.rxjava3.core.Single

interface GitHubRepo {
    fun getRepoGitHub(user: String): Single<List<Repo>>
}