package com.spartons.booklibraryapp.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.spartons.booklibraryapp.database.BookLibraryDatabase
import com.spartons.booklibraryapp.di.qualifiers.ApplicationContextQualifier
import com.spartons.booklibraryapp.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides

@Module(includes = [ApplicationContextModule::class])
class RoomModule {

    companion object {
        private const val DATABASE_NAME = "book.db"
    }

    @Provides
    @CustomApplicationScope
    fun provideBookDatabase(@ApplicationContextQualifier context: Context) =
            Room.databaseBuilder(context, BookLibraryDatabase::class.java, DATABASE_NAME).build()
}
