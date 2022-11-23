package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.viewModels.ShoeViewModel

class DetailsFragment : Fragment() {
    lateinit var shoeViewModel: ShoeViewModel ;


    private val shoeVM: ShoeViewModel by activityViewModels();
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false)
        shoeViewModel = ViewModelProvider(this)[ShoeViewModel::class.java];
        binding.viewModel = shoeViewModel;
        binding.lifecycleOwner = this
        binding.saveButtonId.setOnClickListener { view ->
            val shoe = shoeViewModel.showViewModel();
            Log.i("shoe",shoe.toString());
            shoeVM.addNewShoe(shoe);
            // navigate Back to list
            view.findNavController().navigateUp();
        }
        binding.cancelButton.setOnClickListener { view->
            view.findNavController().navigateUp();
        }
        return binding.root;
    }

}