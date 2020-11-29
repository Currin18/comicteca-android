package com.jesusmoreira.comicteca.model

import com.google.gson.annotations.SerializedName

data class LogIn (
        @SerializedName("username")
        val userName: String,
        @SerializedName("password")
        val password: String,
        @SerializedName("grant_type")
        val grantType: String = "password"
)