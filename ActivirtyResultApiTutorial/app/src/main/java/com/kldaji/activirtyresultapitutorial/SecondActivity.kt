package com.kldaji.activirtyresultapitutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kldaji.activirtyresultapitutorial.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setBackClickListener()
    }

    private fun setBackClickListener() {
        binding.btnSecondBack.setOnClickListener {
            val intent = Intent()
            intent.putExtra("test", "123")
            setResult(100, intent)
            finish()
        }
    }
}
