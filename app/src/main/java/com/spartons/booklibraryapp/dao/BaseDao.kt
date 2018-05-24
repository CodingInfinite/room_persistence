package com.spartons.booklibraryapp.dao

import android.arch.persistence.room.*

@Dao
interface BaseDao<in T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T): Long

    @Delete
    fun delete(type : T)

    @Update
    fun update(type : T)

    @Insert
    fun insert(vararg objects : T)

}