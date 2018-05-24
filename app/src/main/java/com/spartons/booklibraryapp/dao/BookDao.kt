package com.spartons.booklibraryapp.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.spartons.booklibraryapp.data.BookItem

@Dao
interface BookDao : BaseDao<BookItem> {

    @Query(value = "SELECT * FROM books")
    fun getAllBooks(): List<BookItem>

    @Query(value = "SELECT * FROM books WHERE author_id = :authorId")
    fun getBooksWithAuthorId(authorId: Long): List<BookItem>
}