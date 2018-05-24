package com.spartons.booklibraryapp.di.components

import com.spartons.booklibraryapp.activities.CreateBookActivity
import com.spartons.booklibraryapp.activities.FirstActivity
import com.spartons.booklibraryapp.di.scopes.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface ActivityComponent : AppComponent {

    fun inject(bookActivity: CreateBookActivity)

    fun inject(firstActivity: FirstActivity)
}