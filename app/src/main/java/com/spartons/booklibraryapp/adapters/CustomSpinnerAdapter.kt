package com.spartons.booklibraryapp.adapters

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.spartons.booklibraryapp.data.AuthorModel


class CustomSpinnerAdapter(context: Context, private val resource: Int, private val authors: List<AuthorModel>) : ArrayAdapter<AuthorModel>(context, resource, authors) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return createItemView(position, parent!!)
    }

    @NonNull
    override fun getView(position: Int, @Nullable convertView: View?, @NonNull parent: ViewGroup): View {
        return createItemView(position, parent)
    }

    private fun createItemView(position: Int, parent: ViewGroup): View {
        val view = inflater.inflate(resource, parent, false)
        val offTypeTv = view.findViewById(android.R.id.text1) as TextView
        val offerData = authors[position]
        offTypeTv.text = offerData.authorName
        return view
    }
}