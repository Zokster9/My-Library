package com.example.mylibrary

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllBooksActivity : AppCompatActivity() {

    private lateinit var booksRecView: RecyclerView
    private lateinit var adapter: BookRecViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_books)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        adapter = BookRecViewAdapter(Utils.allBooks!!, this, "allBooks")
        booksRecView = findViewById(R.id.booksRecView)
        booksRecView.adapter = adapter
        booksRecView.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}