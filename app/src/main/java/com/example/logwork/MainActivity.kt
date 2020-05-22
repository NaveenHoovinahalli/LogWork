package com.example.logwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val myViewModel: HeroesViewModelKot by viewModel()
    private var clockValue: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkActivityResponse(intent)

        btnClock.setOnClickListener {
            myViewModel.fetchData()
            }
        }

    private fun checkActivityResponse(intent: Intent?) {
/*
        intent?.let {
            clockValue = it.getStringExtra("ClockValue")
            clockValue?.let {
                if (it.equals("Clocking In...")) {
                    callClockApi("https://api.helpster.tech/v1/staff-requests/26074/clock-in/")
                } else {
                    callClockApi("https://api.helpster.tech/v1/staff-requests/26074/clock-out/")
                }
            }
        }*/

    }
}

