package com.example.anthonyodu.api

import com.example.oduanthony.model.FilterArray
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {


    @GET("assessment/filter.json")
    fun getFilterList(): Call<FilterArray>
}