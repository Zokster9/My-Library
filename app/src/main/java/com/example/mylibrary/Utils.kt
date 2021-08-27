package com.example.mylibrary

object Utils {
    var allBooks: ArrayList<Book>? = null
    var alreadyReadBooks: ArrayList<Book>? = null
    var wishListBooks: ArrayList<Book>? = null
    var currentlyReadingBooks: ArrayList<Book>? = null
    var favouriteBooks: ArrayList<Book>? = null

    init {
        if (allBooks == null) {
            allBooks = ArrayList()
            initData()
        }

        if (alreadyReadBooks == null) {
            alreadyReadBooks = ArrayList()
        }

        if (wishListBooks == null) {
            wishListBooks = ArrayList()
        }

        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = ArrayList()
        }

        if (favouriteBooks == null) {
            favouriteBooks = ArrayList()
        }
    }

    private fun initData() {
        val longDesc1 = "The events of 1Q84 take place in Tokyo during a fictionalized year of 1984, " +
                "with the first volume set between April and June, the second between July and September, and the third between October and December." +
                "The book opens with a woman named Aomame (青豆) as she rides a taxi to a work assignment. " +
                "She hears the Sinfonietta by Leoš Janáček playing on the radio and immediately recognizes it, " +
                "somehow having detailed knowledge of its history and context. When the taxi gets stuck in a " +
                "traffic jam on the Shibuya Route of the Shuto Expressway, the driver suggests she climb down " +
                "an emergency escape to reach her meeting, warning her that it might change the very nature of " +
                "reality. Aomame follows the driver's advice. Eventually, Aomame makes her way to a hotel in " +
                "Shibuya and poses as an attendant in order to kill a guest. She performs the murder with an " +
                "ice pick that leaves no trace on its victim. It is revealed that Aomame's job is to kill men who have committed domestic violence."

        val longDesc2 = "Influenced by philosophers such as Søren Kierkegaard, Arthur Schopenhauer, " +
                "and Friedrich Nietzsche, Camus introduces his philosophy of the absurd. The absurd " +
                "lies in the juxtaposition between the fundamental human need to attribute meaning " +
                "to life and the \"unreasonable silence\" of the universe in response.[1] Does the " +
                "realization of the absurd require suicide? Camus answers, \"No. It requires revolt.\" " +
                "He then outlines several approaches to the absurd life. In the final chapter, Camus " +
                "compares the absurdity of man's life with the situation of Sisyphus, a figure of Greek " +
                "mythology who was condemned to repeat forever the same meaningless task of pushing a " +
                "boulder up a mountain, only to see it roll down again. The essay concludes, \"The " +
                "struggle itself ... is enough to fill a man's heart. One must imagine Sisyphus happy\"."

        allBooks?.add(Book(1, "1Q84", "Haruki Murakami", 1350,
            "https://images-na.ssl-images-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
            "A work of maddening brilliance", longDesc1))
        allBooks?.add(Book(2, "The Myth Of Sisyphus", "Albert Camus", 250,
            "https://images-na.ssl-images-amazon.com/images/I/41wRI29K-iL._SX301_BO1,204,203,200_.jpg",
            "One of the most influential works of this century, this is a crucial exposition of existentialist thought",
            longDesc2))
    }

    fun getBookById(bookId: Int): Book? {
        allBooks?.forEach { book ->
            if (book.id == bookId) {
                return book
            }
        }
        return null
    }

    fun addToAlreadyRead(book: Book): Boolean = alreadyReadBooks!!.add(book)

    fun addToWishList(book: Book): Boolean = wishListBooks!!.add(book)

    fun addToCurrentlyReading(book: Book): Boolean = currentlyReadingBooks!!.add(book)

    fun addToFavourite(book: Book): Boolean = favouriteBooks!!.add(book)

    fun removeFromAlreadyRead(book: Book): Boolean = alreadyReadBooks!!.remove(book)

    fun removeFromWishList(book: Book): Boolean = wishListBooks!!.remove(book)

    fun removeFromCurrentlyReading(book: Book): Boolean = currentlyReadingBooks!!.remove(book)

    fun removeFromFavourite(book: Book): Boolean = favouriteBooks!!.remove(book)
}