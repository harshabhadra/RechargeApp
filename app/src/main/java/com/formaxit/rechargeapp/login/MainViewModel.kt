package com.formaxit.rechargeapp.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.formaxit.rechargeapp.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

lateinit var userName: String
private lateinit var repository: Repository

class MainViewModel : ViewModel() {
    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    //Initializing Coroutine job
    val mainViewModelJob = Job()

    //Initialize the uiScope
    val uiScope = CoroutineScope(Dispatchers.Main + mainViewModelJob)


    private var _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
        userName = ""
        repository = Repository.getInstance()
    }

    fun refuseAuthentication() {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate(username: String, password: String) {
        if (passwordIsValidForUsername(username, password)) {
            userName = username
            authenticationState.value = AuthenticationState.AUTHENTICATED
        } else {
            authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
        }
    }

    private fun passwordIsValidForUsername(username: String, password: String): Boolean {

        uiScope.launch {

        }
        return true
    }

    fun logInUser():LiveData<String>{
          return repository.getLoginCred("2222222222", "123456")
    }
}