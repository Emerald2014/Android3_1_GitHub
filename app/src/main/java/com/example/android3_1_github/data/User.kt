package com.example.android3_1_github.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url")    val avatarUrl: String,
    val url: String
) :Parcelable

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
