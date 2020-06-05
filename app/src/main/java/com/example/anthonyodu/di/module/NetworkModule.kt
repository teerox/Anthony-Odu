package com.example.anthonyodu.di.module

import android.app.Activity
import android.content.Context
import com.example.anthonyodu.MyApplication
import com.example.anthonyodu.api.ApiService
import com.example.anthonyodu.utils.Utility.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val application: MyApplication) {

    @Provides
    fun context(): Context {
        return application
    }



    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    internal fun provideBalanceService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}