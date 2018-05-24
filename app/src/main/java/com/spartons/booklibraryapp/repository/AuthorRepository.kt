package com.spartons.booklibraryapp.repository

import com.spartons.booklibraryapp.dao.AuthorDao
import com.spartons.booklibraryapp.data.AuthorModel
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class AuthorRepository @Inject constructor(private val authorDao: AuthorDao) : BaseRepository<AuthorModel>() {

    override fun insert(t: AuthorModel): Single<Long> = Single.fromCallable {
        authorDao.insert(t)
    }

    override fun delete(t: AuthorModel): Completable = Completable.fromCallable {
        authorDao.delete(t)
    }

    override fun update(t: AuthorModel): Completable = Completable.fromCallable {
        authorDao.update(t)
    }

    fun getAllAuthors(): Single<List<AuthorModel>> = Single.create<List<AuthorModel>> {
        it.onSuccess(authorDao.getAllAuthors())
    }

    fun getAuthorWithId(authorId: Long) = Maybe.create<AuthorModel?> {
        it.onSuccess(authorDao.getAuthorWithId(authorId)!!)
    }

    fun getAllIds() = Single.create<List<Long>> {
        it.onSuccess(authorDao.getAllIds())
    }

}