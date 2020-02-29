package com.formaxit.rechargeapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogIn(
    @SerializedName("RequestInput")
    @Expose
    val requestInput: RequestInput
)

data class Authentication(
    @SerializedName("username")
    @Expose
    var username: String,
    @SerializedName("password")
    @Expose
    var password: String
)

data class Token(
    @SerializedName("tokenId")
    @Expose
    var tokenId: String
)

class RequestInput(
    @SerializedName("Authentication")
    @Expose
    var authentication: Authentication,
    @SerializedName("Token")
    @Expose
    var token: Token
)