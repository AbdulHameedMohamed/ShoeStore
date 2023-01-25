package com.udacity.shoestore.ui.details

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.ui.base.BaseFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsScreenBinding
import com.udacity.shoestore.ui.home.MainViewModel

class DetailsFragment : BaseFragment<FragmentDetailsScreenBinding>(R.layout.fragment_details_screen) {
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()

        binding.mainViewModel = mainViewModel

        // binding variable can be accessed from FragmentX
        binding.apply {
            btnAdd.setOnClickListener {
                // For Loop And Check
                mainViewModel?.addShoe()

                val action =
                    DetailsFragmentDirections.actionDetailsScreenToHomeFragment()
                requireView().findNavController().navigate(action)
            }
        }
    }
}