package com.example.mylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavouriteBookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_book)

        val favouriteBookRecView: RecyclerView = findViewById(R.id.favouriteBookRecView)
        val adapter = BookRecViewAdapter(Utils.favouriteBooks!!, this, "favourite")
        favouriteBookRecView.adapter = adapter
        favouriteBookRecView.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}