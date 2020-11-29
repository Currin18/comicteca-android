package com.jesusmoreira.comicteca.model

import com.google.gson.annotations.SerializedName

data class Token (
    @SerializedName("access_token")
    var accessToken: String? = null,
    @SerializedName("created_at")
    var createdAt: Long? = null,
    @SerializedName("expires_in")
    var expiresIn: Long? = null,
    @SerializedName("refresh_token")
    var refreshToken: String? = null,
    @SerializedName("scope")
    var scope: String? = null,
    @SerializedName("token_type")
    var tokenType: String? = null,
)