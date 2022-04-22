package com.example.android3_1_github.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android3_1_github.R
import com.example.android3_1_github.data.Repo
import com.example.android3_1_github.databinding.DetailsFragmentItemBinding
import com.example.android3_1_github.ui.main.MainFragment

class DetailsFragmentAdapter() :
    RecyclerView.Adapter<DetailsFragmentAdapter.DetailsViewHolder>() {
    private var detailsData: List<Repo> = listOf()

    fun setRepos(data: List<Repo>) {
        detailsData = data
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailsFragmentAdapter.DetailsViewHolder {
        val binding =
            DetailsFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: DetailsFragmentAdapter.DetailsViewHolder, position: Int) {
        holder.bind(detailsData[position])
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount() = detailsData.size

    inner class DetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(repo: Repo) {
            DetailsFragmentItemBinding.bind(itemView).apply {
                detailsItemName.text = repo.name
                if (repo.private) {
                    detailsItemPrivateIv.load(R.drawable.private_cr) {
                        crossfade(true)
                    }
                }
            }
        }
    }
}