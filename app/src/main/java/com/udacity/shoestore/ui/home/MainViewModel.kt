package com.udacity.shoestore.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.models.Shoe

class MainViewModel constructor(application: Application) : AndroidViewModel(application){

    // The list of words - the front of the list is the next word to guess
    private lateinit var shoeList: MutableList<Shoe>

    val shoe: Shoe= Shoe("", 0.0, "", "")

    init {
        initShoeList()
    }

    private val _list = MutableLiveData(shoeList)
    val list: LiveData<MutableList<Shoe>>
        get() = _list

//    private var _newShoe = MutableLiveData<Shoe?>()
//    val newShoe:LiveData<Shoe?>
//    get() = _newShoe

    private var _goToDetailsScreen = MutableLiveData(false)
    val goToDetailsScreen: LiveData<Boolean>
        get() = _goToDetailsScreen

    private fun initShoeList() {
        shoeList = mutableListOf(
            Shoe(name = "Shoe 1", size = 45.5, company = "company 1", description = "Description 1", images = mutableListOf("", "")),
            Shoe(name = "Shoe 2", size = 46.1, company = "company 2", description = "Description 2", images = mutableListOf("", "")),
            Shoe(name = "Shoe 3", size = 40.4, company = "company 3", description = "Description 3", images = mutableListOf("", "")),
            Shoe(name = "Shoe 4", size = 38.8, company = "company 4", description = "Description 4", images = mutableListOf("", "")),
            Shoe(name = "Shoe 5", size = 22.0, company = "company 5", description = "Description 5", images = mutableListOf("", ""))
        )
    }

    fun goToDetailsScreen() {
        _goToDetailsScreen.value= true
    }

    fun addShoe() {
        _list.value= _list.value!!.plus(shoe).toMutableList()
    }

    fun doneNavigationToDetailsScreen() {
        _goToDetailsScreen.value= false
    }
}