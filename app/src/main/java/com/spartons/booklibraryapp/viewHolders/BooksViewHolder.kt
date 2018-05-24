package com.spartons.booklibraryapp.viewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.spartons.booklibraryapp.R

class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val singleBookNameTextView = itemView.findViewById<TextView>(R.id.singleBookNameTextView)
    val singleBookAuthorNameTextView = itemView.findViewById<TextView>(R.id.singleBookAuthorNameTextView)

}