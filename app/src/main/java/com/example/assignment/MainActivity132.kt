package com.example.assignment

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment.databinding.ActivityMain132Binding

class MainActivity132 : AppCompatActivity() {

    private lateinit var binding: ActivityMain132Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain132Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Load fade-in + slide-up animation
        val fadeInUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        // ✅ Start the Lottie animation
        binding.lottieSuccess.playAnimation()

        // ✅ Wait for Lottie animation to finish
        binding.lottieSuccess.addAnimatorListener(object : android.animation.Animator.AnimatorListener {
            override fun onAnimationStart(animation: android.animation.Animator) {}

            override fun onAnimationEnd(animation: android.animation.Animator) {
                // Show text and button after Lottie ends
                showTextElements(fadeInUp)
            }

            override fun onAnimationCancel(animation: android.animation.Animator) {}
            override fun onAnimationRepeat(animation: android.animation.Animator) {}
        })

        // ✅ Button action
        binding.btnDone.setOnClickListener {
            finish()
        }
    }

    private fun showTextElements(anim: android.view.animation.Animation) {
        val views = listOf(
            binding.tvTitle,
            binding.tvAmount,
            binding.tvDesc,
            binding.btnDone
        )

        for (view in views) {
            view.visibility = View.VISIBLE
            view.startAnimation(anim)
            view.alpha = 1f
        }
    }
}
