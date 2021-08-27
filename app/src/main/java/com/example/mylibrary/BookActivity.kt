package com.example.mylibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class BookActivity : AppCompatActivity() {
    private lateinit var bookImg: ImageView
    private lateinit var btnAddToCurrentlyReading: Button
    private lateinit var btnAddToWishList: Button
    private lateinit var btnAddToAlreadyRead: Button
    private lateinit var btnAddToFavourites: Button
    private lateinit var txtBookName: TextView
    private lateinit var txtAuthorName: TextView
    private lateinit var txtPages: TextView
    private lateinit var txtLongDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        initViews()

        if (intent != null) {
            val bookId = intent.getIntExtra("bookId", -1)
            if (bookId != -1) {
                val book = Utils.getBookById(bookId)
                if (book != null) {
                    setData(book)
                    handleAlreadyRead(book)
                    handleWishListBooks(book)
                    handleCurrentlyReadingBooks(book)
                    handleFavouriteBooks(book)
                }
            }
        }
    }

    private fun handleFavouriteBooks(book: Book) {
        val favouriteBooks = Utils.favouriteBooks
        favouriteBooks?.forEach { b ->
            if (b.id == book.id) {
                btnAddToFavourites.isEnabled = false
                return
            }
        }

        btnAddToFavourites.setOnClickListener {
            if (Utils.addToFavourite(book)) {
                Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, FavouriteBookActivity::class.java))
            } else {
                Toast.makeText(this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleCurrentlyReadingBooks(book: Book) {
        val currentlyReadingBooks = Utils.currentlyReadingBooks
        currentlyReadingBooks?.forEach { b ->
            if (b.id == book.id) {
                btnAddToCurrentlyReading.isEnabled = false
                return
            }
        }

        btnAddToCurrentlyReading.setOnClickListener {
            if (Utils.addToCurrentlyReading(book)) {
                Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CurrentlyReadingBookActivity::class.java))
            } else {
                Toast.makeText(this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleWishListBooks(book: Book) {
        val wishListBooks = Utils.wishListBooks
        wishListBooks?.forEach { b ->
            if (b.id == book.id) {
                btnAddToWishList.isEnabled = false
                return
            }
        }

        btnAddToWishList.setOnClickListener {
            if (Utils.addToWishList(book)) {
                Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, WishListActivity::class.java))
            } else {
                Toast.makeText(this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleAlreadyRead(book: Book) {
        val alreadyReadBooks = Utils.alreadyReadBooks
        alreadyReadBooks?.forEach { b ->
            if (b.id == book.id) {
                btnAddToAlreadyRead.isEnabled = false
                return
            }
        }

        btnAddToAlreadyRead.setOnClickListener {
            if (Utils.addToAlreadyRead(book)) {
                Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AlreadyReadBookActivity::class.java))
            } else {
                Toast.makeText(this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setData(book: Book) {
        txtBookName.text = book.name
        txtAuthorName.text = book.author
        txtPages.text = book.pages.toString()
        txtLongDesc.text = book.longDesc
        Glide.with(this).asBitmap().load(book.imageUrl).into(bookImg)
    }

    private fun initViews() {
        bookImg = findViewById(R.id.bookImg)
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading)
        btnAddToWishList = findViewById(R.id.btnAddToWishList)
        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyReadList)
        btnAddToFavourites = findViewById(R.id.btnAddToFavourites)
        txtBookName = findViewById(R.id.txtBook)
        txtAuthorName = findViewById(R.id.txtAuthorName)
        txtPages = findViewById(R.id.txtPages)
        txtLongDesc = findViewById(R.id.txtLongDesc)
    }
}