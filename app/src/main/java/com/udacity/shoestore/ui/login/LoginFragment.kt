package com.udacity.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.util.showToast

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    val binding get() = _binding!! // Helper Property

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.apply {
            btnSignIn.setOnClickListener {
                // For Loop And Check
                if(etEmail.text.isBlank()|| etPassword.text.isBlank()) {
                    val action =
                        LoginFragmentDirections.actionLoginFragmentToOnBoardingFragment()
                    requireView().findNavController().navigate(action)
                } else {
                    context?.showToast("Enter All Fields Ya Nagm", Toast.LENGTH_LONG)
                }
            }
            tvForgetPassword.setOnClickListener {
                Snackbar.make(tvForgetPassword,
                    "Write Any Email Address and Pass to Pass hhhh",
                    Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}