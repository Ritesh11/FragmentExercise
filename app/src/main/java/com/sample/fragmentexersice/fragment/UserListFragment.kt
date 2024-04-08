package com.sample.fragmentexersice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.fragmentexersice.databinding.FragmentUserListBinding
import com.sample.fragmentexersice.fragment.adapter.UserListAdapter
import com.sample.fragmentexersice.model.User
import com.sample.fragmentexersice.repository.RegisterRepository
import com.sample.fragmentexersice.room.UserDatabase
import com.sample.fragmentexersice.viewmodel.RegisterViewModel
import com.sample.fragmentexersice.viewmodel.RegisterViewModelFactory

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private lateinit var _viewModel: RegisterViewModel
    private lateinit var _userListAdapter: UserListAdapter
    private lateinit var userList: ArrayList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        val dao = UserDatabase.getInstance(requireActivity().applicationContext).userDao
        val repository = RegisterRepository(dao)
        val factory = RegisterViewModelFactory(repository)
        _viewModel = ViewModelProvider(requireActivity(), factory)[RegisterViewModel::class.java]
        binding.userListViewModel = _viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userList = ArrayList()
        setAdapter()
        _viewModel.user.observe(viewLifecycleOwner) {
            _userListAdapter.updateList(it)
        }
    }

    private fun setAdapter() {
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvUserList.layoutManager = layoutManager
        _userListAdapter = UserListAdapter(requireContext(), userList) { selectedItem: User ->
            itemClicked(
                selectedItem
            )
        }
        binding.rvUserList.adapter = _userListAdapter
    }

    private fun itemClicked(user: User) {
        Toast.makeText(requireContext(), "Item clicked is -> ${user.name}", Toast.LENGTH_SHORT)
            .show()
    }


}