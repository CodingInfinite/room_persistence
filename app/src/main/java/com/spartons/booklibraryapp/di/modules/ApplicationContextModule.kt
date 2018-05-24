package com.spartons.booklibraryapp.di.modules

import android.content.Context
import com.spartons.booklibraryapp.di.qualifiers.ApplicationContextQualifier
import com.spartons.booklibraryapp.di.scopes.CustomApplicationScope
import dagger.Module
import dagger.Provides


@Module
class ApplicationContextModule(private var context: Context) {

    @Provides
    @CustomApplicationScope
    @ApplicationContextQualifier
    fun getContext() = context
}