package com.sample.fragmentexersice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.sample.fragmentexersice.R
import com.sample.fragmentexersice.databinding.FragmentRegisterBinding
import com.sample.fragmentexersice.repository.RegisterRepository
import com.sample.fragmentexersice.room.UserDatabase
import com.sample.fragmentexersice.viewmodel.RegisterViewModel
import com.sample.fragmentexersice.viewmodel.RegisterViewModelFactory

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var _viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val dao = UserDatabase.getInstance(requireActivity().applicationContext).userDao
        val repository = RegisterRepository(dao)
        val factory = RegisterViewModelFactory(repository)
        _viewModel = ViewModelProvider(requireActivity(), factory)[RegisterViewModel::class.java]
        binding.registerViewModel = _viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateBtn.setOnClickListener{
            view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }

}