package com.spartons.booklibraryapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "books")
data class BookItem(@ColumnInfo(name = "author_id") val authorId: Long, @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "book_id") val bookId: Long = 0, val name: String, val authorName: String)
