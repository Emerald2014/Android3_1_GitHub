package com.example.android3_1_github.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3_1_github.data.Repo
import com.example.android3_1_github.retrofit.RetrofitImpl
import com.example.android3_1_github.ui.main.GitHubState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailsViewModel(
    private val liveData: MutableLiveData<GitHubState<Repo>> = MutableLiveData(),
    private val userGitHubImpl: RetrofitImpl = RetrofitImpl()
) : ViewModel() {
    fun getLiveData(): LiveData<GitHubState<Repo>> = liveData

    fun getRepoFromServer(login: String) {
        userGitHubImpl.getRetrofitImpl().getRepos(login).enqueue(
            object : Callback<List<Repo>> {
                override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                    response.body()?.let {
                        liveData.postValue(GitHubState.Success(it))
                    }
                }

                override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )

    }
}