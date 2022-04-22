package com.example.android3_1_github.data.userrepo

import com.example.android3_1_github.data.User
import com.example.android3_1_github.data.getLocalUsers
import com.example.android3_1_github.domain.UserRepo

class RetrofitUserRepoImpl : UserRepo {
    override fun getAllUsers(): List<User> = getLocalUsers()

    override fun deleteUser(id: String) {
        TODO("Not yet implemented")
    }
}