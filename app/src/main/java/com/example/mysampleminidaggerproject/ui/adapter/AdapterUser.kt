package com.example.mysampleminidaggerproject.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mysampleminidaggerproject.core.model.UserM
import com.example.templete.R
import com.example.templete.databinding.ItemRclUsersBinding

class AdapterUser(private val context: Context) :
    RecyclerView.Adapter<AdapterUser.UserViewHolder>() {
    private var usersList = arrayListOf<UserM>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = DataBindingUtil.inflate<ItemRclUsersBinding>(
            LayoutInflater.from(context),
            R.layout.item_rcl_users,
            parent,
            false
        )

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        usersList.size.let {
            holder.bindData(usersList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initList(users: List<UserM>) {
        usersList.clear()
        usersList.addAll(users)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(val binding: ItemRclUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: UserM) {
            binding.userInformation = user
        }
    }
}
