package com.example.anthonyodu

import android.app.Application
import com.example.anthonyodu.di.ApplicationComponent
import com.example.anthonyodu.di.DaggerApplicationComponent
import com.example.anthonyodu.di.module.NetworkModule
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.security.ProviderInstaller
import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext

class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeSSLContext()
        component = DaggerApplicationComponent.builder()
            .networkModule(NetworkModule(this))
            .build()
    }

    fun getSharedComponent(): ApplicationComponent {
        return component
    }


    private fun initializeSSLContext() {
        try {
            SSLContext.getInstance("TLSv1.2");
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        try {
            ProviderInstaller.installIfNeeded(this)
        } catch (e: GooglePlayServicesRepairableException) {
            e.printStackTrace()
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }
    }
}