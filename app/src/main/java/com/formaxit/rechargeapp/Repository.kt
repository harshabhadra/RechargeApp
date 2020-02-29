package com.formaxit.rechargeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.formaxit.rechargeapp.Network.AppsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService = AppsApi.retrofitService
    companion object{
        fun getInstance():Repository{
            return Repository()
        }
    }

    private val _loginCred = MutableLiveData<String>()

    fun getLoginCred(userName:String, password:String):LiveData<String>{
        loginUser(userName,password)
        return _loginCred
    }

    private fun loginUser(userName: String="2222222222", password: String="123456", tokenId:String = "123456785") {

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