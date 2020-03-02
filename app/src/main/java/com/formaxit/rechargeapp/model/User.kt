package com.formaxit.rechargeapp.model

import com.squareup.moshi.Json


data class User (
    @Json(name = "agentcode")
    var agentcode: String,
    @Json(name = "notification")
    var notification: Notification,
    @Json(name = "bankDetails")
    var bankDetails: List<BankDetail>,
    @Json(name = "UserDetails")
    var userDetails: UserDetails,
    @Json(name = "message")
    var message: String,
    @Json(name = "status")
    var status: String
)

data class UserDetails (
    @Json(name = "userId")
    var userId: String,
    @Json(name = "roleId")
    var roleId: Int,
    @Json(name = "wlId")
    var wlId: String,
    @Json(name = "userName")
    var userName: String,
    @Json(name = "name")
    var name: String,
    @Json(name = "firmName")
    var firmName: String,
    @Json(name = "address")
    var address: String,
    @Json(name = "city")
    var city: String,
    @Json(name = "pinCode")
    var pinCode: String,
    @Json(name = "state")
    var state: String,
    @Json(name = "country")
    var country: String,
    @Json(name = "mobile")
    var mobile: String,
    @Json(name = "uplineId")
    var uplineId: String,
    @Json(name = "email")
    var email: String,
    @Json(name = "createdDate")
    var createdDate: String,
    @Json(name = "createdTime")
    var createdTime: String,
    @Json(name = "balance")
    var balance: Double,
    @Json(name = "lockedAmount")
    var lockedAmount: Double,
    @Json(name = "pan")
    var pan: String,
    @Json(name = "aadhaar")
    var aadhaar: String,
    @Json(name = "panbalance")
    var panbalance: Double
)

data class Notification (
    @Json(name = "complain")
    var complain: Int,
    @Json(name = "balRequest")
    var balRequest: Int,
    @Json(name = "utility")
    var utility: Int,
    @Json(name = "insurance")
    var insurance: Int
)

data class BankDetail(
    @Json(name = "id")
    var id: Int,
    @Json(name = "accName")
    var accName: String,
    @Json(name = "accNo")
    var accNo: String,
    @Json(name = "ifscCode")
    var ifscCode: String,
    @Json(name = "branchName")
    var branchName: String,
    @Json(name = "bankName")
    var bankName: String,
    @Json(name = "wlId")
    var wlId: String,
    @Json(name = "date")
    var date: String,
    @Json(name = "time")
    var time: String)
