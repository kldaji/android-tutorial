package com.kldaji.viewpagertutorial.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kldaji.viewpagertutorial.FragmentActivity
import com.kldaji.viewpagertutorial.fragment.ViewPagerFragment

class FragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return ViewPagerFragment()
    }
}
