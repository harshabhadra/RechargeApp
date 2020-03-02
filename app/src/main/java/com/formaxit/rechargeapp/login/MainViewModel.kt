package com.formaxit.rechargeapp.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.formaxit.rechargeapp.Repository
import com.formaxit.rechargeapp.database.UserCred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

lateinit var userName: String
private lateinit var repository: Repository

class MainViewModel(application: Application) : ViewModel() {
    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }
    private val loginRepository: Repository = Repository(application)

    //Initializing Coroutines job
    private val mainViewModelJob = Job()

    //Initialize the uiScope
    private val uiScope = CoroutineScope(Dispatchers.Main + mainViewModelJob)

    //Store user cred
    val user: LiveData<UserCred>

    val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
        userName = ""
        repository = Repository.getInstance()
        user = loginRepository.getUser()
    }

    //Get User
    fun insertUser(userCred: UserCred){
        uiScope.launch {
            loginRepository.insertUser(userCred)
        }
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

    fun logInUser(usern: String, password: String) :LiveData<String>{
        return repository.getLoginCred(usern,password)
    }

    //Check if the user entries are valid
    fun isValidCred(username: String, password: String):Boolean{
        return username.isNotEmpty() && password.isNotEmpty()
    }
}