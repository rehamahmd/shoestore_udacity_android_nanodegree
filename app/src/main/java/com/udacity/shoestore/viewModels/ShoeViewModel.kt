package com.udacity.shoestore.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    private val list = MutableLiveData<MutableList<Shoe>>();
    val shoeList: LiveData<MutableList<Shoe>> get() = list

    fun addNewShoe(shoe : Shoe){
        Log.i("addNewShoe",shoe.name);
        if (list.value == null) {
            list.value = mutableListOf(shoe)
            Log.i("shoe added list size",list.value?.size.toString());
            return;
        }
        list.value?.add(shoe);


    }

    fun showViewModel(): Shoe{
        Log.i("SHOEVIEWMODEL","GET SHOE");
        return Shoe(name.value ?: "",size?.value?.toDouble() ?: 0.0, company.value ?:"" , description.value?:"" );
    }
}