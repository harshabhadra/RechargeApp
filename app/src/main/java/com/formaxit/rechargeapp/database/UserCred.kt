package com.formaxit.rechargeapp.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_data_table")
data class UserCred(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id:Long = 0L,
    @NonNull
    @ColumnInfo(name = "user_name")
    val userName:String,
    @ColumnInfo(name = "password")
    val password:String
)