package com.example.anthonyodu

import android.app.Application
import com.example.anthonyodu.di.ApplicationComponent
import com.example.anthonyodu.di.DaggerApplicationComponent
import com.example.anthonyodu.di.module.NetworkModule

class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
            .networkModule(NetworkModule(this))
            .build()
    }

    fun getSharedComponent(): ApplicationComponent {
        return component
    }
}