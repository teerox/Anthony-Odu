package com.example.anthonyodu.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.datasource.LocalDataSource
import com.example.anthonyodu.datasource.RemoteDataSource
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.model.FilterArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FilterRepository @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource){



    //API RESPONSE
    fun getFilterList(): MutableLiveData<FilterArray>? {
        val filterArray: MutableLiveData<FilterArray>? = MutableLiveData()
        val call = remoteDataSource.getFilterRepo()
        call.enqueue(object : Callback<FilterArray> {
            override fun onFailure(call: Call<FilterArray>, t: Throwable) {
                Log.e("Failed",t.message.toString())
                filterArray?.value = null
            }

            override fun onResponse(call: Call<FilterArray>, response: Response<FilterArray>) {
                if (response.isSuccessful) {
                    Log.e("Successful","Filter successfully retrieved")
                    filterArray?.value = response.body()
                }
            }
        })
        return filterArray

    }



    suspend fun getCarOwner(data:Filter):CarOwnerList{
        return localDataSource.filterFile(data)
    }




}