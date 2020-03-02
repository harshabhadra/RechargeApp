package com.formaxit.rechargeapp.login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.formaxit.rechargeapp.R
import com.formaxit.rechargeapp.databinding.FragmentLogInBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class LogInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val logInBinding = FragmentLogInBinding.inflate(inflater,container,false)

        val application = requireNotNull(this.activity).application
        val mainViewModelFractory = MainViewModelFractory(application)
        val mainViewModel = ViewModelProvider(this, mainViewModelFractory).get(MainViewModel::class.java)

        //Set on click listener to the login button
        logInBinding.logInButton.setOnClickListener {
            val userName = logInBinding.logInUserName.text.toString()
            val password = logInBinding.logInPassword.text.toString()
            mainViewModel.isValidCred(userName,password).let {
                mainViewModel.logInUser(userName,password).observe(viewLifecycleOwner, Observer {
                    it?.let{
                        Timber.e("Response: ${it.toString()}")
                    }?:let {
                        Timber.e("No Response")
                    }
                })
            }
        }

        return logInBinding.root
    }


}
