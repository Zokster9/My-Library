package com.example.mylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CurrentlyReadingBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currently_reading_book)

        val currentlyBookRecView: RecyclerView = findViewById(R.id.currentlyBookRecView)
        val adapter = BookRecViewAdapter(Utils.currentlyReadingBooks!!, this, "currentlyReading")
        currentlyBookRecView.adapter = adapter
        currentlyBookRecView.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}