package com.spartons.booklibraryapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.spartons.booklibraryapp.R
import com.spartons.booklibraryapp.data.BookItem
import com.spartons.booklibraryapp.viewHolders.BooksViewHolder

class BooksAdapter(private val context: Context, private val books: List<BookItem>) : RecyclerView.Adapter<BooksViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(layoutInflater.inflate(R.layout.single_book_item_view, parent, false))
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.singleBookAuthorNameTextView.text = books[position].authorName
        holder.singleBookNameTextView.text = books[position].name
    }
}