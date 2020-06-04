package com.example.anthonyodu.screens.carowner

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.repository.FilterRepository
import com.example.anthonyodu.utils.Utility
import kotlinx.coroutines.*
import java.io.File
import javax.inject.Inject

class CarOwnerViewModel @Inject constructor(private var filterRepository: FilterRepository){


    suspend fun filterFile(data: Filter):CarOwnerList{
        return withContext(Dispatchers.IO) {
            val result = filterRepository.getCarOwner(data)
            result
        }


    }





}