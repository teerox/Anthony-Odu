package com.example.anthonyodu.screens.filter

import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.example.anthonyodu.repository.FilterRepository
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.utils.Utility
import com.example.anthonyodu.utils.Utility.CAR_OWNER_DATA
import com.example.anthonyodu.utils.Utility.DOWNLOAD_URL
import com.example.anthonyodu.utils.Utility.FOLDER
import java.io.File
import javax.inject.Inject

class FilterViewModel @Inject constructor(context: Context,private val filterRepository: FilterRepository){

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


    private val file by lazy {
        File(context.filesDir, FOLDER)
    }

    private val absoluteFile by lazy {
        File(context.filesDir, FOLDER.plus("/$CAR_OWNER_DATA"))
    }


    private val _startMyDownload = MutableLiveData<Boolean>()
    val startMyDownload: LiveData<Boolean>
        get() = _startMyDownload


    private val _completeDownload = MutableLiveData<Boolean>()
    val completeDownload: LiveData<Boolean>
        get() = _completeDownload


    val grantAccess = MutableLiveData<Boolean>()


    //If file already exist
    fun checkDataExist() {
        if (!absoluteFile.exists()) {
            _startMyDownload.value = false
            startDownload()
        }
        Log.e("Data","Data Exist")

    }

    private fun startDownload(): Int {
        if (!file.exists()) file.mkdir()
        return PRDownloader.download(
            DOWNLOAD_URL,
            file.absolutePath,
            CAR_OWNER_DATA
        )
            .build()
            .setOnStartOrResumeListener {
                Log.e("Started","Started")
            }
            .setOnPauseListener {
                Log.e("Pause","Pause")
            }
            .setOnCancelListener {
                Log.e("Cancel","Cancel")
            }
            .setOnProgressListener { }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    _completeDownload.value = true
                    grantAccess.value = true
                    Log.e("Completed","Completed")
                }

                override fun onError(error: com.downloader.Error?) {
                    Log.e("error",error?.serverErrorMessage.toString())
                    _completeDownload.value = true

                }
            })


    }

    fun showDialog(){
        Log.e("Dialogue","Dialogue On")
        showDialog()
    }

    fun dismiss() {
        Log.e("Dialogue","Dialogue Off")
        dismiss()
    }
}