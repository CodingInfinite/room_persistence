package com.spartons.booklibraryapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "authors")
data class AuthorModel(@PrimaryKey(autoGenerate = true)
                       @ColumnInfo(name = "author_id")
                       val authorId: Long = 0,
                       @ColumnInfo(name = "author_name")
                       var authorName: String)
