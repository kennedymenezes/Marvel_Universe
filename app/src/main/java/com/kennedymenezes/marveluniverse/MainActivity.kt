package com.kennedymenezes.marveluniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kennedymenezes.marveluniverse.dashboard.ui.fragment.DashboardFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, DashboardFragment()).commit()
    }
}