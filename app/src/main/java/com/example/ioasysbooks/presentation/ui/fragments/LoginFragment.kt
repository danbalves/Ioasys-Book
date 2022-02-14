    package com.example.ioasysbooks.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.ioasysbooks.databinding.FragmentLoginBinding
import com.example.ioasysbooks.presentation.viewmodel.LoginViewModel
import com.example.ioasysbooks.util.ViewState
import org.koin.androidx.viewmodel.ext.android.getViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel: LoginViewModel by lazy {
        getViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(inflater, container, false ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        addObserves()
    }

    private fun setListener() {
        binding.loginButton.setOnClickListener {
            binding.run {
                loginViewModel.login(
                    edInputEmail.text.toString(),
                    edInputPassword.text.toString()
                )
                edInputEmail.addTextChangedListener {
                    errorMessage.visibility = View.GONE
                }
                edInputPassword.addTextChangedListener {
                    errorMessage.visibility = View.GONE
                }
            }
        }
    }



    private fun addObserves(){
        loginViewModel.loggedUserViewState.observe(viewLifecycleOwner){ state ->

            when(state){
                is ViewState.Success -> {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToBookListFragment()
                    )
                }
                is ViewState.Error -> {
                    binding.progressDialog.visibility = View.GONE
                    binding.errorMessage.visibility = View.VISIBLE
                }
                is ViewState.Loading -> {
                    binding.progressDialog.visibility = View.VISIBLE
                }

                else -> Unit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        loginViewModel.resetViewState()
        _binding = null
    }

}