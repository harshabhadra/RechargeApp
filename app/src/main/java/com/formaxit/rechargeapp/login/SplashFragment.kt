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

        val text:TextView = view.findViewById(R.id.splash_text)
        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.logInUser().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.e("SplashFragment",it)
                text.text = it
            }
        })
        return view
    }


}
