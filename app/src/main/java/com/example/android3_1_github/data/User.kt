package com.example.android3_1_github.data

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url")    val avatarUrl: String,
    val url: String
)

fun getLocalUsers(): List<User> {
    return listOf(
        User(
            1,
            "name1",
            "avatarUrl",
            "URL"
        )
    )
}
