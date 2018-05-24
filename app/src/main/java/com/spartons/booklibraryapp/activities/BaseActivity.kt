package com.spartons.booklibraryapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import com.spartons.booklibraryapp.app.MyCustomApplicationClass
import com.spartons.booklibraryapp.di.components.ActivityComponent
import com.spartons.booklibraryapp.di.components.DaggerActivityComponent

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private lateinit var component: ActivityComponent

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerActivityComponent
                .builder()
                .appComponent(getApp().getAppComponent())
                .build()
    }

    protected fun getComponent() = component

    private fun getApp() = applicationContext as MyCustomApplicationClass
}