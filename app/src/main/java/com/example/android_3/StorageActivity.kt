package com.example.android_3

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class StorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        val textViewStorage: TextView = findViewById(R.id.textViewStorageContent)
        val buttonBack: Button = findViewById(R.id.buttonBack)
        val buttonDelete: Button = findViewById(R.id.buttonDelete)

        val data = readFromFile(this)
        textViewStorage.text = if (data.isNotEmpty()) data else "Дані відсутні"

        buttonBack.setOnClickListener {
            finish()
        }

        buttonDelete.setOnClickListener {
            deleteFile(this)
            textViewStorage.text = "Дані відсутні"
            Toast.makeText(this, "Дані видалено", Toast.LENGTH_SHORT).show()
        }
    }

    private fun readFromFile(context: Context): String {
        val file = File(context.filesDir, "data.txt")
        return if (file.exists()) file.readText() else ""
    }

    private fun deleteFile(context: Context) {
        val file = File(context.filesDir, "data.txt")
        if (file.exists()) {
            file.delete()
        }
    }
}
