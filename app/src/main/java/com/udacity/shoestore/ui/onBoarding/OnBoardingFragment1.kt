package com.udacity.shoestore.ui.onBoarding

import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding
import com.udacity.shoestore.ui.base.BaseFragment

class OnBoardingFragment1 : BaseFragment<FragmentOnBoardingBinding>(R.layout.fragment_on_boarding) {

    override fun onStart() {
        super.onStart()

        // binding variable can be accessed from FragmentX
        binding.apply {
            btnGoTo.setOnClickListener {
                // For Loop And Check
                val action =
                    OnBoardingFragment1Directions.actionOnBoardingFragmentToInstructionFragment()
                requireView().findNavController().navigate(action)
            }
        }
    }
}