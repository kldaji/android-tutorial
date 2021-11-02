package com.kldaji.servicetutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kldaji.servicetutorial.databinding.ActivityMainBinding
import com.kldaji.servicetutorial.service.SimpleService

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setStartServiceEvent()
        processServiceIntent(intent)
    }

    private fun setStartServiceEvent() {
        binding.btnMainService.setOnClickListener {
            val intent = Intent(this, SimpleService::class.java)
            intent.putExtra("input", binding.etMainInput.text.toString())
            startService(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        processServiceIntent(intent)
    }

    private fun processServiceIntent(intent: Intent?) {
        intent ?: return
        val input = intent.getStringExtra("input") ?: return
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
    }
}
