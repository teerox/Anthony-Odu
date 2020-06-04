package com.example.anthonyodu.di

import com.example.anthonyodu.di.module.NetworkModule
import com.example.anthonyodu.screens.MainActivity
import com.example.anthonyodu.screens.carowner.CarOwnerFragment
import com.example.anthonyodu.screens.filter.FilterFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: CarOwnerFragment)
    fun inject(fragment: FilterFragment)

}