package com.example.android3_1_github.domain

import com.example.android3_1_github.data.User

interface UserRepo {
    fun getAllUsers(): List<User>

    fun deleteUser(id: String)
}