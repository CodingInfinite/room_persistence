package com.spartons.booklibraryapp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.spartons.booklibraryapp.dao.AuthorDao
import com.spartons.booklibraryapp.dao.BookDao
import com.spartons.booklibraryapp.data.AuthorModel
import com.spartons.booklibraryapp.data.BookItem

@Database(entities = [AuthorModel::class, BookItem::class], version = 1)
abstract class BookLibraryDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao

    abstract fun bookDao(): BookDao
}
