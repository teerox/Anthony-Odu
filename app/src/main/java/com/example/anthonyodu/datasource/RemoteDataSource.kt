package com.example.anthonyodu.datasource

import com.example.anthonyodu.api.ApiService
import com.example.anthonyodu.model.FilterArray
import retrofit2.Call
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){


    fun getFilterRepo(): Call<FilterArray> {
        return apiService.getFilterList()
    }
}