package com.example.anthonyodu.di.module

import com.example.anthonyodu.api.ApiService
import com.example.anthonyodu.utils.Utility.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


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