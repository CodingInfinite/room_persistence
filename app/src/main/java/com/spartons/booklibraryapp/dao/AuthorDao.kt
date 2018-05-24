package com.spartons.booklibraryapp.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.spartons.booklibraryapp.data.AuthorModel

@Dao
interface AuthorDao : BaseDao<AuthorModel> {

    @Query(value = "SELECT * FROM authors")
    fun getAllAuthors(): List<AuthorModel>

    @Query(value = "SELECT * FROM authors WHERE author_id = :authorId")
    fun getAuthorWithId(authorId: Long): AuthorModel?

    @Query(value = "SELECT author_id FROM authors")
    fun getAllIds(): List<Long>
}