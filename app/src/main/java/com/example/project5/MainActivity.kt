package com.example.project5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if there's no fragment in the fragmentContainer and add TranslationFragment
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
            val fragment = TranslationFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}
