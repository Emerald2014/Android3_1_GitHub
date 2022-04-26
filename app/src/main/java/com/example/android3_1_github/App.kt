package com.example.android3_1_github

import android.app.Application
import android.content.Context
import com.example.android3_1_github.data.GitHubImpl
import com.example.android3_1_github.domain.GitHubRepo
import com.example.android3_1_github.domain.GitHubUser

class App : Application() {
    val gitHubUser: GitHubUser by lazy { GitHubImpl() }
    val gitHubRepo: GitHubRepo by lazy { GitHubImpl() }
}

val Context.app: App
    get() = applicationContext as App