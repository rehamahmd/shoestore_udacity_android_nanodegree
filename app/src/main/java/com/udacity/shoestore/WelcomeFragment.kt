package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false)
        binding.wlcButtonId.setOnClickListener {view: View ->
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_instructionsFragment);
        }
        var args = WelcomeFragmentArgs.fromBundle(arguments!!);
        Log.i("args",args.toString());


        binding.wlcTextId.text = "${binding.wlcTextId.text} ${args.username}"

        return binding.root
    }

}