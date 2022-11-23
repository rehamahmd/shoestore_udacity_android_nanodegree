package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.databinding.ShowRowLayoutBinding
import com.udacity.shoestore.viewModels.ShoeViewModel

class ListingFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels();
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = shoeViewModel;
        setHasOptionsMenu(true)
        binding.floatingActionButton2.setOnClickListener { view->
            view.findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailsFragment())
        }

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            Log.i("OBSERVER","");
            for (shoe in shoeList){
                var shoeRowBinding : ShowRowLayoutBinding = DataBindingUtil.inflate(
                    layoutInflater,R.layout.show_row_layout,container,false
                )
                shoeRowBinding.shoe = shoe;
                Log.i("Bind Shoe To View", shoe.name);
                binding.shoeLinearView.addView(shoeRowBinding.root)
            }

        })
        return binding.root;
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//       navigate to login as first screen
        findNavController().navigateUp()
        return true;
    }
}