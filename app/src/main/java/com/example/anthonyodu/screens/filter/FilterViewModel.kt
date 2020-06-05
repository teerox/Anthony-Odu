package com.example.anthonyodu.screens.filter

import android.app.Dialog
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.downloader.Error
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.example.anthonyodu.repository.FilterRepository
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.utils.DownloadProgress
import com.example.anthonyodu.utils.Utility.CAR_OWNER_DATA
import com.example.anthonyodu.utils.Utility.DOWNLOAD_URL
import com.example.anthonyodu.utils.Utility.FOLDER
import java.io.File
import javax.inject.Inject

class FilterViewModel @Inject constructor(context: Context,private val filterRepository: FilterRepository,private val dialog: DownloadProgress){

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

    private var _currentDownload = MutableLiveData<Int>()
    private val currentDownload:MutableLiveData<Int>
            get() = _currentDownload

    private val _startMyDownload = MutableLiveData<Boolean>()
    val startMyDownload: LiveData<Boolean>
        get() = _startMyDownload


    private val _completeDownload = MutableLiveData<Boolean>()
    val completeDownload: LiveData<Boolean>
        get() = _completeDownload


    val grantAccess = MutableLiveData<Boolean>()


    //If file already exist
    fun checkDataExist() {
        if (!absoluteFile.exists() || _startMyDownload.value == false) {
            _startMyDownload.value = false
            startDownload()
        }else {
            Log.e("Data", "Data Exist")
        }


    }


    //Start Downloading
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
            .setOnProgressListener {
                val currentMb =(it.currentBytes / 1000000).toInt()
                _currentDownload.value = currentMb
              //  _totalDownload.value = totalMb


            }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    _completeDownload.value = true
                    grantAccess.value = true
                    Log.e("Completed","Completed")
                }

                override fun onError(error: Error?) {
                    Log.e("error",error?.serverErrorMessage.toString())
                    Log.e("error","Faileddd")
                    _completeDownload.value = false

                }
            })
    }



    fun showDialog(dialogs: Dialog){
        Log.e("Dialogue","Dialogue On")
        dialog.showDialog(dialogs)
            currentDownload.observeForever {current ->
               // Log.e("Dialogue",current.toString())
                val percentage = ((current * 100)/21)
                val currentDownloadText = percentage.toString()
                dialog.update(currentDownloadText,percentage)
            }




    }

    fun dismiss(dialogs: Dialog) {
        Log.e("Dialogue","Dialogue Off")
        dialog.dismiss(dialogs)
    }
}