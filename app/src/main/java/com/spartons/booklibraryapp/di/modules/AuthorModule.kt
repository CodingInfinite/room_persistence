package com.spartons.booklibraryapp.di.modules

import com.spartons.booklibraryapp.dao.AuthorDao
import com.spartons.booklibraryapp.database.BookLibraryDatabase
import com.spartons.booklibraryapp.di.scopes.CustomApplicationScope
import com.spartons.booklibraryapp.repository.AuthorRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RoomModule::class])
class AuthorModule {

    @Provides
    @CustomApplicationScope
    fun provideAuthorDao(bookLibraryDatabase: BookLibraryDatabase) = bookLibraryDatabase.authorDao()

    @Provides
    @CustomApplicationScope
    fun provideAuthorRepo(authorDao: AuthorDao) = AuthorRepository(authorDao)

}