package com.example.android3_1_github.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android3_1_github.domain.GitHubRepo

class DetailsViewModelFactory constructor(
    private val repo: GitHubRepo,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(repo) as T
    }
}