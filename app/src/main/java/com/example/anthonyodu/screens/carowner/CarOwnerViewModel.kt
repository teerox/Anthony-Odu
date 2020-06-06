package com.example.anthonyodu.screens.carowner


import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.repository.FilterRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class CarOwnerViewModel @Inject constructor(private var filterRepository: FilterRepository){


    //Fetch data from repository
    suspend fun filterFile(data: Filter):CarOwnerList{
        return withContext(Dispatchers.IO) {
            val result = filterRepository.getCarOwner(data)
            result
        }


    }





}