package com.spartons.booklibraryapp.repository

import com.spartons.booklibraryapp.dao.BookDao
import com.spartons.booklibraryapp.data.BookItem
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookDao: BookDao) : BaseRepository<BookItem>() {

    override fun insert(t: BookItem): Single<Long> = Single.fromCallable {
        bookDao.insert(t)
    }

    override fun delete(t: BookItem): Completable = Completable.fromCallable {
        bookDao.delete(t)
    }

    override fun update(t: BookItem): Completable = Completable.fromCallable {
        bookDao.update(t)
    }

    fun getAllBooks(): Single<List<BookItem>> = Single.create<List<BookItem>> {
        it.onSuccess(bookDao.getAllBooks())
    }

    fun getBookWithAuthorId(authorId: Long) = Single.create<List<BookItem>> {
        it.onSuccess(bookDao.getBooksWithAuthorId(authorId))
    }
}