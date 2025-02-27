package com.example.android_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, InputFragment())
            .commit()
    }

    fun showResultFragment(selectedBook: String, selectedYear: String) {
        val resultFragment = ResultFragment.newInstance(selectedBook, selectedYear)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, resultFragment)
            .addToBackStack(null)
            .commit()
    }

    fun showInputFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, InputFragment())
            .commit()
    }

    fun openStorageActivity() {
        val intent = Intent(this, StorageActivity::class.java)
        startActivity(intent)
    }
}
