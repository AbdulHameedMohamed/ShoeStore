package com.udacity.shoestore.ui.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.ui.base.FragmentX
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.models.Shoe

class HomeFragment : FragmentX<FragmentHomeBinding>(R.layout.fragment_home) {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    private val args: HomeFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()

        // binding variable can be accessed from FragmentX

        binding.mainViewModel = mainViewModel

        checkForArgs()

        observeLiveData()

        setHasOptionsMenu(true)
    }

    private fun checkForArgs() {
        args.shoeArgs?.let {
            mainViewModel.addShoe(shoe = it)
        }
    }

    private fun observeLiveData() {
        mainViewModel.list.observe(viewLifecycleOwner) { shoeList ->
            showList(shoeList)
    //            for (shoe in shoeList) {
    //                val holderBinding= ItemShoeBinding.inflate(layoutInflater, binding.ll, false)
    //                holderBinding.apply {
    //                    tvName.text = shoe.name
    //                    tvCompany.text= shoe.company
    //                    tvDescription.text= shoe.description
    //                }
    //                binding.ll.addView(holderBinding.root)
    //            }
        }

        mainViewModel.goToDetailsScreen.observe(viewLifecycleOwner) {
            if(it) {
                navigateToDetailsScreen(it)
            }
        }
//
//        mainViewModel.newShoe.observe(viewLifecycleOwner) { shoe ->
//            addShoeToList(shoe)
//        }

        mainViewModel.list.observe(viewLifecycleOwner) { shoeList ->
            showList(shoeList)
        }
    }

    private fun showList(shoeList: MutableList<Shoe>?) {
        if (shoeList != null) {
            // do something
            binding.ll.removeAllViews()
            for (shoe in shoeList) {
                addShoeToList(shoe)
            }
        }
    }

    private fun makeTextView(shoe: Shoe): View {
        val textView = TextView(context)
        textView.text = getString(R.string.makeText, shoe.name, shoe.company, shoe.size.toString(), shoe.description)
        return textView
    }

    private fun addViewToViewGroup(view: View, viewGroup: ViewGroup) {
        viewGroup.addView(view)
    }

    private fun addShoeToList(shoe: Shoe?) {
        shoe?.let {
            addViewToViewGroup(makeTextView(shoe), binding.ll)
        }
    }

    private fun navigateToDetailsScreen(it: Boolean) {
        if (it) {
            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailsScreen()
            requireView().findNavController().navigate(action)
            mainViewModel.doneNavigationToDetailsScreen()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(item)
    }
}