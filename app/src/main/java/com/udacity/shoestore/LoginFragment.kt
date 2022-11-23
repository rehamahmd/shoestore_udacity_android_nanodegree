package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)


        binding.loginButton.setOnClickListener {view: View ->
            val n = binding.emailEditId.text.toString();
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(n));
        }
        binding.registerButton.setOnClickListener {view: View ->
            val n = binding.emailEditId.text.toString();
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(n));
        }
        return binding.root
    }

}