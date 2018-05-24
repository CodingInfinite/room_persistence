package com.spartons.booklibraryapp.di.modules

import com.spartons.booklibraryapp.dao.BookDao
import com.spartons.booklibraryapp.database.BookLibraryDatabase
import com.spartons.booklibraryapp.di.scopes.CustomApplicationScope
import com.spartons.booklibraryapp.repository.BookRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RoomModule::class])
class BookModule {

    @Provides
    @CustomApplicationScope
    fun provideBookDao(bookLibraryDatabase: BookLibraryDatabase) = bookLibraryDatabase.bookDao()

    @Provides
    @CustomApplicationScope
    fun provideBookRepo(bookDao: BookDao) = BookRepository(bookDao)
}