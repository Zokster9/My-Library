package com.example.mylibrary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class BookRecViewAdapter(
    private val books: ArrayList<Book>,
    private val mContext: Context,
    private val parentActivity: String
) :
    RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parent: MaterialCardView = view.findViewById(R.id.parent)
        val imgBook: ImageView = view.findViewById(R.id.imgBook)
        val txtName: TextView = view.findViewById(R.id.txtBookName)
        val downArrow: ImageView = view.findViewById(R.id.btnDownArrow)
        val upArrow: ImageView = view.findViewById(R.id.btnUpArrow)
        val expandedRelLayout: RelativeLayout = view.findViewById(R.id.expandedRelLayout)
        val txtAuthor: TextView = view.findViewById(R.id.txtAuthor)
        val txtShortDesc: TextView = view.findViewById(R.id.txtShortDesc)
        val btnDelete: TextView = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_book, parent, false)
        val holder = ViewHolder(view)

        holder.downArrow.setOnClickListener {
            val book = books[holder.adapterPosition]
            book.isExpanded = !book.isExpanded
            notifyItemChanged(holder.adapterPosition)
        }
        holder.upArrow.setOnClickListener {
            val book = books[holder.adapterPosition]
            book.isExpanded = !book.isExpanded
            notifyItemChanged(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = books[position].name
        Glide.with(mContext)
            .asBitmap()
            .load(books[position].imageUrl)
            .into(holder.imgBook)

        holder.parent.setOnClickListener {
            val intent = Intent(mContext, BookActivity::class.java)
            intent.putExtra("bookId", books[position].id)
            mContext.startActivity(intent)
        }

        holder.txtAuthor.text = books[position].author
        holder.txtShortDesc.text = books[position].shortDesc

        if (books[position].isExpanded) {
            TransitionManager.beginDelayedTransition(holder.parent)
            holder.expandedRelLayout.visibility = View.VISIBLE
            holder.downArrow.visibility = View.GONE

            if (parentActivity == "allBooks")
                holder.btnDelete.visibility = View.GONE
            else {
                holder.btnDelete.visibility = View.VISIBLE
                when (parentActivity) {
                    "alreadyRead" -> holder.btnDelete.setOnClickListener {
                        removeBookFromList(Utils::removeFromAlreadyRead, position)
                    }

                    "currentlyReading" -> holder.btnDelete.setOnClickListener {
                        removeBookFromList(Utils::removeFromCurrentlyReading, position)
                    }

                    "favourite" -> holder.btnDelete.setOnClickListener {
                        removeBookFromList(Utils::removeFromFavourite, position)
                    }

                    "wishlist" -> holder.btnDelete.setOnClickListener {
                        removeBookFromList(Utils::removeFromWishList, position)
                    }
                }
            }

        } else {
            TransitionManager.beginDelayedTransition(holder.parent)
            holder.expandedRelLayout.visibility = View.GONE
            holder.downArrow.visibility = View.VISIBLE
        }
    }

    private fun removeBookFromList(remove: (Book) -> Boolean, position: Int) {
        val builder = AlertDialog.Builder(mContext)
        builder.setMessage("Are you sure you want to delete '${books[position].name}'?")
        builder.setPositiveButton("Yes") { _, _ ->
            val toBeRemovedBook = books[position]
            if (remove(books[position])) {
                Toast.makeText(mContext, "${toBeRemovedBook.name} is removed", Toast.LENGTH_SHORT).show()
                notifyItemRemoved(position)
            } else
                Toast.makeText(mContext, "Something wrong happened, Please try again", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.create().show()
    }

    override fun getItemCount(): Int = books.size
}