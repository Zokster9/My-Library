package com.example.mylibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var logo: ImageView
    private lateinit var btnAllBooks: Button
    private lateinit var btnCurrentlyReading: Button
    private lateinit var btnAlreadyRead: Button
    private lateinit var btnWishlist: Button
    private lateinit var btnFavourite: Button
    private lateinit var btnAbout: Button
    private lateinit var txtLicence: TextView
    private lateinit var txtAppName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnAllBooks.setOnClickListener {
            startActivity(Intent(this, AllBooksActivity::class.java))
        }
        
        btnAlreadyRead.setOnClickListener {
            startActivity(Intent(this, AlreadyReadBookActivity::class.java))
        }

        btnCurrentlyReading.setOnClickListener {
            startActivity(Intent(this, CurrentlyReadingBookActivity::class.java))
        }

        btnWishlist.setOnClickListener {
            startActivity(Intent(this, WishListActivity::class.java))
        }

        btnFavourite.setOnClickListener {
            startActivity(Intent(this, FavouriteBookActivity::class.java))
        }

        btnAbout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.app_name)
            builder.setMessage("Designed by yours truly, Zoran Bukorac")
            builder.setNegativeButton("Dismiss") { _, _ -> }
            builder.setPositiveButton("Visit") { _, _ ->
                startActivity(Intent(this, WebsiteActivity::class.java))
            }
            builder.create().show()
        }
    }

    private fun initView() {
        logo = findViewById(R.id.imgLogo)
        btnAllBooks = findViewById(R.id.btnAllBooks)
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading)
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead)
        btnWishlist = findViewById(R.id.btnWishlist)
        btnFavourite = findViewById(R.id.btnFavourite)
        btnAbout = findViewById(R.id.btnAbout)
        txtLicence = findViewById(R.id.txtLicence)
        txtAppName = findViewById(R.id.txtAppName)
    }
}