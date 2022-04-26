package com.example.android3_1_github.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_1_github.domain.GitHubRepo
import com.example.android3_1_github.domain.entity.Repo
import io.reactivex.rxjava3.kotlin.subscribeBy


class DetailsViewModel(
    private val repo: GitHubRepo
) : ViewModel() {
    private val _repos = MutableLiveData<List<Repo>>()
    val repos: LiveData<List<Repo>> = _repos

    fun getRepoFromServer(login: String) {
        repo.getRepoGitHub(login).subscribeBy {
            _repos.postValue(it)
        }
    }
}