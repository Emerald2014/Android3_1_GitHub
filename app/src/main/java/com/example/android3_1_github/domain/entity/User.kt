package com.example.android3_1_github.domain.entity

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

