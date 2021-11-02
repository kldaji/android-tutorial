package com.kldaji.activirtyresultapitutorial

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.kldaji.activirtyresultapitutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri ?: return@registerForActivityResult
            binding.ivGallery.setImageURI(uri)
        }
    private val requestActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            Log.d("MainActivity", "${activityResult.resultCode}")
            if (activityResult.resultCode == 100) {
                val intent = activityResult.data ?: return@registerForActivityResult
                Log.d("MainActivity", "${intent.getStringExtra("test")}")
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setGalleryClickListener()
        setNavigateClickListener()
        Log.d("MainActivity", "OK")
    }

    private fun setGalleryClickListener() {
        binding.btnMainGallery.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun setNavigateClickListener() {
        binding.btnMainNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            requestActivity.launch(intent)
        }
    }
}
