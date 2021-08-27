package com.example.mylibrary

class Book(
    val id: Int,
    val name: String,
    val author: String,
    val pages: Int,
    val imageUrl: String,
    val shortDesc: String,
    val longDesc: String,
    var isExpanded: Boolean = false
) {
    override fun toString(): String {
        return "Book(id=$id, name='$name', author='$author', pages=$pages, imageUrl='$imageUrl', shortDesc='$shortDesc', longDesc='$longDesc')"
    }
}