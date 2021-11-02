package com.kldaji.viewpagertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.kldaji.viewpagertutorial.adapter.FragmentAdapter
import com.kldaji.viewpagertutorial.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private val binding: ActivityFragmentBinding by lazy {
        ActivityFragmentBinding.inflate(layoutInflater)
    }
    private val adapter: FragmentAdapter by lazy {
        FragmentAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
        setTabLayoutWithViewPager()
    }

    private fun setAdapter() {
        binding.vpFragment.adapter = adapter
    }

    private fun setTabLayoutWithViewPager() {
        TabLayoutMediator(binding.tlFragment, binding.vpFragment) { tab, position ->
            tab.text = "$position"
        }.attach()
    }
}
