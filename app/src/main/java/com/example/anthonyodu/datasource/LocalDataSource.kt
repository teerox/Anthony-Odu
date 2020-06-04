package com.example.anthonyodu.datasource

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.utils.Utility
import com.example.anthonyodu.utils.Utility.CAR_OWNER_DATA
import com.example.anthonyodu.utils.Utility.FOLDER
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class LocalDataSource @Inject constructor(context: Context){


    private val absoluteFile by lazy {
        File(context.filesDir, FOLDER.plus("/${CAR_OWNER_DATA}"))
    }



    private suspend fun readFile():CarOwnerList{
        return Utility.readFile(absoluteFile)
    }


    suspend fun filterFile(data: Filter):CarOwnerList{
        return withContext(Dispatchers.IO) {
            val fileList = readFile()
            val result = Utility.filter(fileList, data)
            result
        }


    }
}