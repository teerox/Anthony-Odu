package com.example.anthonyodu.utils

import android.content.Context
import android.net.ConnectivityManager


object Utility {

    const val MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 1
    const val BASE_URL = "https://ven10.co/"
    const val FOLDER = "Venten"
    const val DOWNLOAD_URL =
        "https://drive.google.com/u/0/uc?id=1giBv3pK6qbOPo0Y02H-wjT9ULPksfBCm&export=download"
    const val CAR_OWNER_DATA = "car_owner_data.csv"


    object CSVHeader {
        const val ID: Int = 0
        const val FIRST_NAME = 1
        const val LAST_NAME = 2
        const val EMAIL = 3
        const val COUNTRY = 4
        const val CAR_MODEL = 5
        const val YEAR = 6
        const val CAR_COLOR = 7
        const val GENDER = 8
        const val JOB_TITLE = 9
        const val BIO = 10
    }

    fun isNetworkAvailable(context: Context): Boolean? {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
                return true
            } else if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                return true
            }
        } else {
            return false
        }
        return false
    }

}