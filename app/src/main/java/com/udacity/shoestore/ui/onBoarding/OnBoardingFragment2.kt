package com.udacity.shoestore.ui.onBoarding

import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.ui.base.BaseFragment

class OnBoardingFragment2 : BaseFragment<FragmentInstructionBinding>(R.layout.fragment_instruction) {

    override fun onStart() {
        super.onStart()

        // binding variable can be accessed from FragmentX
        binding.btnGoToHome.setOnClickListener {
            val action =
                OnBoardingFragment2Directions.actionInstructionFragmentToHomeFragment()
            requireView().findNavController().navigate(action)
        }
    }
}