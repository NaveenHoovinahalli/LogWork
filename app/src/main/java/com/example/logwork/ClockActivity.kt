package com.example.logwork


import android.os.Bundle
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.clock_activity.*



class ClockActivity: AppCompatActivity() {

    private var clockValue: String? = null
    lateinit var animator: ValueAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.clock_activity)

        textClockCancel.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        textClockCancel.setOnClickListener {
            animator.removeAllListeners()
            onBackPressed()
        }

        intent?.let {
            clockValue = it.getStringExtra("ClockValue")
            clockValue.let {
                if(it.equals("Clock In")) {
                    clockValue = "Clocking In..."

                } else {
                    clockValue = "Clocking Out..."

                }
                clockText.text = clockValue
            }
        }

        animator = ValueAnimator.ofInt(0, progressBar.getMax())
        animator.duration = 10000
        animator.addUpdateListener { animation -> progressBar.setProgress(animation.animatedValue as Int) }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                val newIntent = Intent(this@ClockActivity, MainActivity::class.java)
                newIntent.putExtra("ClockValue", clockValue)
                startActivity(newIntent)
            }
        })
        animator.start()

    }


}