package com.example.android3_1_github.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android3_1_github.databinding.MainFragmentItemBinding
import com.example.android3_1_github.domain.entity.User

class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {
    lateinit var listUser: List<User>
    fun setData(listUser: List<User>) {
        this.listUser = listUser
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragmentAdapter.MainViewHolder {
        val binding =
            MainFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount() = listUser.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: User) {
            MainFragmentItemBinding.bind(itemView).apply {
                itemIdTv.text = user.id.toString()
                itemLoginTv.text = user.login
                itemAvatar.load(user.avatarUrl)

                root.setOnClickListener { itemClickListener.onItemViewClick(user) }
            }
        }
    }
}