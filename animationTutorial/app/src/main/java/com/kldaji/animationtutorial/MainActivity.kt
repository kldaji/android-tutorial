package com.kldaji.animationtutorial

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.kldaji.animationtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setAnimation1()
        setAnimation2()
        setAnimation2WithXml()
        setAnimation3()
        setAnimation3WithXml()
        setAnimation4()
        setAnimation4WithXml()
    }

    private fun setAnimation1() {
        binding.tvAnimation1.setOnClickListener {
            binding.tvAnimation1.animate()
                .alpha(0.5f)
                .scaleX(0.5f)
                .scaleY(0.5f)
                .setDuration(3000)
                .withStartAction {
                    Log.d("MainActivity", "Animation1 starts")
                }
                .withEndAction {
                    Log.d("MainActivity", "Animation1 ends")
                }
        }
    }

    private fun setAnimation2() {
        val animation2 = ObjectAnimator.ofFloat(binding.tvAnimation2, "translationY", 300f)
        with(animation2) {
            duration = 5000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }

    private fun setAnimation2WithXml() {
        val animatorSet = AnimatorInflater.loadAnimator(this, R.animator.animation2)
        with(animatorSet) {
            setTarget(binding.tvAnimation2WithXml)
            start()
        }
    }

    private fun setAnimation3() {
        val rotationX = PropertyValuesHolder.ofFloat(View.ROTATION_X, 0f, 3600f)
        val textColor = PropertyValuesHolder.ofInt("textColor",
            Color.parseColor("#FFFF0000"),
            Color.parseColor("#FF0000FF"))
        textColor.setEvaluator(ArgbEvaluator())
        val animator =
            ObjectAnimator.ofPropertyValuesHolder(binding.tvAnimation3, rotationX, textColor)
        with(animator) {
            duration = 5000
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }
    }

    private fun setAnimation3WithXml() {
        val animatorSet = AnimatorInflater.loadAnimator(this, R.animator.animation3)
        with(animatorSet) {
            setTarget(binding.tvAnimation3WithXml)
            start()
        }
    }

    private fun setAnimation4() {
        val rotationX = PropertyValuesHolder.ofFloat(View.ROTATION_X, 0f, 3600f)
        val textColor = PropertyValuesHolder.ofInt("textColor",
            Color.parseColor("#FFFF0000"),
            Color.parseColor("#FF0000FF"))
        textColor.setEvaluator(ArgbEvaluator())
        val animator =
            ObjectAnimator.ofPropertyValuesHolder(binding.tvAnimation4, rotationX, textColor)
        with(animator) {
            duration = 5000
            interpolator = AccelerateDecelerateInterpolator()
        }

        val rotationY = PropertyValuesHolder.ofFloat(View.ROTATION_Y, 0f, 3600f)
        val textColor2 = PropertyValuesHolder.ofInt("textColor",
            Color.parseColor("#FF0000FF"),
            Color.parseColor("#FFFF0000"))
        textColor2.setEvaluator(ArgbEvaluator())
        val animator2 =
            ObjectAnimator.ofPropertyValuesHolder(binding.tvAnimation4, rotationY, textColor2)
        with(animator2) {
            duration = 5000
            interpolator = AccelerateDecelerateInterpolator()
        }
        val animatorSet = AnimatorSet()
        with (animatorSet) {
            play(animator2).after(animator)
            start()
        }
    }

    private fun setAnimation4WithXml() {
        val animatorSet = AnimatorInflater.loadAnimator(this, R.animator.animation4)
        with(animatorSet) {
            setTarget(binding.tvAnimation4WithXml)
            start()
        }
    }
}
