package com.spartons.booklibraryapp.app

import android.app.Application
import com.spartons.booklibraryapp.di.components.AppComponent
import com.spartons.booklibraryapp.di.components.DaggerAppComponent
import com.spartons.booklibraryapp.di.modules.ApplicationContextModule

class MyCustomApplicationClass : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .applicationContextModule(ApplicationContextModule(this))
                .build()
    }

    fun getAppComponent() = appComponent
}