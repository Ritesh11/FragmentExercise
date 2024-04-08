package com.sample.fragmentexersice.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.fragmentexersice.databinding.AdapterUserListBinding
import com.sample.fragmentexersice.model.User

class UserListAdapter(
    context: Context,
    private var userList: List<User>,
    private val clickListener: (User) -> Unit
) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(AdapterUserListBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, clickListener)
    }

    fun updateList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val view: AdapterUserListBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(adapterPosition: Int, clickListener: (User) -> Unit) {
            val userInfo = userList[adapterPosition]
            view.tvUserName.text = userInfo.name
            view.tvUserEmail.text = userInfo.email
            view.userContainer.setOnClickListener {
                clickListener(userInfo)
            }

        }
    }
}