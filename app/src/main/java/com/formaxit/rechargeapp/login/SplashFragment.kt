package com.formaxit.rechargeapp.login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.formaxit.rechargeapp.R

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        val application = requireNotNull(this.activity).application
        val mainViewModelFactory = MainViewModelFractory(application)
        val mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.user.observe(viewLifecycleOwner, Observer { userCred->
            userCred?.let {

                view.findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            }?:let {
                view.findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLogInFragment())
            }
        })
        return view
    }


}
