package com.example.android3_1_github.ui.main

import com.example.android3_1_github.data.User

sealed class GitHubState {
    data class Success(val serverResponseData: List<User>) : GitHubState()
}