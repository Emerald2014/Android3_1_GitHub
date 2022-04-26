package com.example.android3_1_github.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_1_github.domain.GitHubUser
import com.example.android3_1_github.domain.entity.User
import io.reactivex.rxjava3.kotlin.subscribeBy

class MainViewModel(
    private val repo: GitHubUser
) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun getUsersFromServer() {
        repo.getUsersGitHub().subscribeBy {
            _users.postValue(it)
        }
    }
}

