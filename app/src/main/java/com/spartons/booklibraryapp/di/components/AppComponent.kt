package com.spartons.booklibraryapp.di.components

import com.spartons.booklibraryapp.di.modules.AuthorModule
import com.spartons.booklibraryapp.di.modules.BookModule
import com.spartons.booklibraryapp.di.scopes.CustomApplicationScope
import com.spartons.booklibraryapp.repository.AuthorRepository
import com.spartons.booklibraryapp.repository.BookRepository
import dagger.Component

@CustomApplicationScope
@Component(modules = [AuthorModule::class, BookModule::class])
interface AppComponent {

    fun bookRepository(): BookRepository

    fun authorRepository(): AuthorRepository
}