package com.example.anthonyodu

import android.app.Application
import com.example.anthonyodu.di.ApplicationComponent
import com.example.anthonyodu.di.DaggerApplicationComponent

class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}