package com.udacity.shoestore.ui.details

import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.navigation.findNavController
import com.udacity.shoestore.ui.base.FragmentX
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsScreenBinding
import com.udacity.shoestore.models.Shoe

class DetailsFragment : FragmentX<FragmentDetailsScreenBinding>(R.layout.fragment_details_screen) {

    override fun onStart() {
        super.onStart()

        // binding variable can be accessed from FragmentX
        binding.apply {
            btnAdd.setOnClickListener {
                // For Loop And Check
                val name= etName.text.toString()
                val company= etCompany.text.toString()
                val shoeSize= etShoeSize.text.toString()
                val description= etDescription.text.toString()
                if (name.isBlank()|| company.isBlank()
                    || shoeSize.isBlank()|| description.isBlank()) {
                    Toast.makeText(context, "Enter All Fields To Make New Shoe", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(!shoeSize.isDigitsOnly()) {
                    Toast.makeText(context, "Enter A Valid Shoe Size", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val shoe= Shoe(name= name, size = shoeSize.toDouble(), company= company, description= description)

                val action =
                    DetailsFragmentDirections.actionDetailsScreenToHomeFragment()
                action.shoeArgs= shoe
                requireView().findNavController().navigate(action)
            }
        }
    }
}