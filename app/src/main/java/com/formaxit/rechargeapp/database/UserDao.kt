package com.formaxit.rechargeapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(userCred: UserCred)

    @Query("SELECT * FROM login_data_table ORDER BY id ASC")
    fun getUserDetails():LiveData<UserCred>

    @Delete
    fun deleteUser(userCred: UserCred)
}