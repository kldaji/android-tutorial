package com.kldaji.viewpagertutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kldaji.viewpagertutorial.databinding.ItemViewPagerMainBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val adapters = mutableListOf(RecyclerViewAdapter(), RecyclerViewAdapter(), RecyclerViewAdapter())

    fun submitList(position: Int, list: List<String>) {
        adapters[position].submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemViewPagerMainBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(adapters[position])
    }

    override fun getItemCount(): Int = adapters.size

    class MainViewHolder(private val binding: ItemViewPagerMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(adapter: RecyclerViewAdapter) {
            binding.rvViewPagerItem.adapter = adapter
        }
    }
}
