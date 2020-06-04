package com.example.anthonyodu.screens.filter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.repository.FilterRepository
import com.example.anthonyodu.model.FilterArray
import javax.inject.Inject

class FilterViewModel @Inject constructor(private val filterRepository: FilterRepository){

    private var _filterList = MutableLiveData<FilterArray>()
    val filterList: LiveData<FilterArray>
        get() = _filterList


    init {
        fetchAllData()
    }

    private fun fetchAllData() {
        filterRepository.getFilterList()?.let {
            _filterList = it

        }
    }
}