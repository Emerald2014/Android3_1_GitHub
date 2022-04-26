package com.example.android3_1_github.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android3_1_github.R
import com.example.android3_1_github.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}