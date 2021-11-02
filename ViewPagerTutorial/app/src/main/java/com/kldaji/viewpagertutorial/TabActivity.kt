package com.kldaji.viewpagertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kldaji.viewpagertutorial.adapter.MainAdapter
import com.kldaji.viewpagertutorial.databinding.ActivityTabBinding

class TabActivity : AppCompatActivity() {

    private val binding: ActivityTabBinding by lazy {
        ActivityTabBinding.inflate(layoutInflater)
    }
    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
        setTabLayoutWithViewPager()
        adapter.submitList(0, listOf("1", "2", "3", "4", "5"))
        adapter.submitList(1, listOf("2", "2", "3", "4", "5"))
    }

    private fun setAdapter() {
        binding.vpTab.adapter = adapter
    }

    private fun setTabLayoutWithViewPager() {
        val title = listOf("1", "2", "3")
        TabLayoutMediator(binding.tlTab, binding.vpTab) { tab, position ->
            tab.text = title[position]
        }.attach()
    }
}
