package com.example.android3_1_github.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android3_1_github.domain.GitHubUser

class MainViewModelFactory constructor(
    private val user: GitHubUser,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(user) as T
    }
}