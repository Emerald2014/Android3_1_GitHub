package com.example.android3_1_github.ui.main

sealed class GitHubState<T> {
    data class Success<T>(val serverResponseData: List<T>) : GitHubState<T>()
}