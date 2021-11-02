package com.kldaji.viewpagertutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kldaji.viewpagertutorial.adapter.MainAdapter
import com.kldaji.viewpagertutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
        setNavigation()
        adapter.submitList(0, listOf("1", "2", "3", "4", "5"))
        adapter.submitList(1, listOf("2", "2", "3", "4", "5"))
    }

    private fun setAdapter() {
        binding.vpMain.adapter = adapter
    }

    private fun setNavigation() {
        binding.btnMainTab.setOnClickListener {
            val intent = Intent(this, TabActivity::class.java)
            startActivity(intent)
        }
        binding.btnMainFragment.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }
}
