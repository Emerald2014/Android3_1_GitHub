package com.example.android3_1_github.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_1_github.data.User
import com.example.android3_1_github.retrofit.RetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val liveData: MutableLiveData<GitHubState> = MutableLiveData(),
    private val userGitHubImpl: RetrofitImpl = RetrofitImpl()
) : ViewModel() {
    fun sendServerRequest() {
        userGitHubImpl.getRetrofitImpl().getUsers().enqueue(
            object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    response.body()?.let {
                        liveData.postValue(GitHubState.Success(it))
                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}

