package com.formaxit.rechargeapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.formaxit.rechargeapp.Network.AppsApi
import com.formaxit.rechargeapp.database.LogInDatabase
import com.formaxit.rechargeapp.database.UserCred
import com.formaxit.rechargeapp.database.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (){

    private val apiService = AppsApi.retrofitService
    private lateinit var userDao:UserDao
    private lateinit var userCred:LiveData<UserCred>
    companion object{
        fun getInstance():Repository{
            return Repository()
        }
    }

    constructor(application: Application) : this() {

        val loginDatabase = LogInDatabase.getInstance(application)
        userDao = loginDatabase.userDao
        userCred = userDao.getUserDetails()
    }
    //Store log in details
    private val _loginCred = MutableLiveData<String>()

    //fun to get user cred
    fun getUser():LiveData<UserCred>{
        return userCred
    }

    //Insert user
    suspend fun insertUser(userCred: UserCred){
        withContext(Dispatchers.IO){
            userDao.insertUser(userCred)
        }
    }

    //Delete user
    suspend fun deleteUser(userCred: UserCred){
        withContext(Dispatchers.IO){
            userDao.deleteUser(userCred)
        }
    }
    //Login User
    fun getLoginCred(userName:String, password:String):LiveData<String>{
        loginUser(userName,password)
        return _loginCred
    }

    //Network call to log in user
    private fun loginUser(userName: String, password: String, tokenId:String = "123456785") {

        val authentication = Authentication(userName,password)
        val token = Token(tokenId)
        val requestInput = RequestInput(authentication, token)
        val logIn = LogIn(requestInput)
        apiService.userLogIn(logIn).enqueue(object:Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {

                _loginCred.value = "Response failure: ${t.message}"
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {

                _loginCred.value = "Response successful: ${response.body()}"
            }

        })
    }


}