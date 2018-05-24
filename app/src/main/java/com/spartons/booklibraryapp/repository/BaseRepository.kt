package com.spartons.booklibraryapp.repository

import io.reactivex.Completable
import io.reactivex.Single


abstract class BaseRepository<in T> {

    abstract fun insert(t: T): Single<Long>

    abstract fun delete(t: T): Completable

    abstract fun update(t: T) : Completable

    fun insert(vararg objects: T) {

    }
}