package com.sample.fragmentexersice.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sample.fragmentexersice.databinding.FragmentUserPostsBinding
import com.sample.fragmentexersice.repository.PostRepository
import com.sample.fragmentexersice.viewmodel.UserPostViewModel
import com.sample.fragmentexersice.viewmodel.UserPostViewModelFactory

class UserPostsFragment : Fragment() {

    private lateinit var binding: FragmentUserPostsBinding
    private lateinit var viewModel: UserPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserPostsBinding.inflate(inflater, container, false)
        val repository = PostRepository()
        val viewModelFactory = UserPostViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)[UserPostViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userPost.observe(viewLifecycleOwner){
           val listItem = it?.listIterator()
            while (listItem?.hasNext()==true){
                val item = listItem.next()
                val result = "Album Title : "+ item.title +"\n"+
                        "Album Id : "+"${item.id}"+"\n"+
                        "User Id : "+"${item.userId}"+"\n\n\n"

                binding.itemPost.append(result)
            }
        }
        viewModel.hitPostApi()
    }

}