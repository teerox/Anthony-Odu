package com.example.anthonyodu.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import de.siegmar.fastcsv.reader.CsvReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


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


    @SuppressLint("DefaultLocale")
    suspend fun filter(list: CarOwnerList, criteria: Filter): CarOwnerList {
        val result = CarOwnerList()
        withContext(Dispatchers.IO) {
            for (i in 0 until list.size) {
                if (list[i].year.toLong() in criteria.start_year..criteria.end_year) {
                    if ((criteria.gender.capitalize() == list[i].gender.capitalize())
                        or (criteria.gender.isEmpty())
                    ) {
                        if ((list[i].country.capitalize() in criteria.countries.map { it.capitalize() })
                            or criteria.countries.isEmpty()
                        ) {
                            if ((list[i].carColor.capitalize() in criteria.colors.map { it.capitalize() })
                                or criteria.colors.isEmpty()
                            ) {
                                result.add(
                                    CarOwner(
                                        list[i].id,
                                        // R.drawable.car1,
                                        list[i].firstName,
                                        list[i].lastName,
                                        list[i].email,
                                        list[i].country,
                                        list[i].carModel,
                                        list[i].year,
                                        list[i].carColor,
                                        list[i].gender,
                                        list[i].jobTitle,
                                        list[i].bio
                                    )
                                )
                            }
                        }
                        // }
                    }
                }
            }
        }
        return result

    }

    suspend fun readFile(absoluteFile: File): CarOwnerList {
        val result = CarOwnerList()
        withContext(Dispatchers.IO) {
            try {
                val csvReader = CsvReader()
                csvReader.setFieldSeparator(',')
                csvReader.setSkipEmptyRows(true)
                csvReader.setContainsHeader(true)
                csvReader.parse(BufferedReader(FileReader(absoluteFile.absolutePath)))
                    .use { csvParser ->
                        while (true) {
                            val row = csvParser.nextRow() ?: break
                            result.add(
                                CarOwner(
                                    row.getField(CSVHeader.ID).toLong(),
                                    // R.drawable.car1,
                                    row.getField(CSVHeader.FIRST_NAME),
                                    row.getField(CSVHeader.LAST_NAME),
                                    row.getField(CSVHeader.EMAIL),
                                    row.getField(CSVHeader.COUNTRY),
                                    row.getField(CSVHeader.CAR_MODEL),
                                    row.getField(CSVHeader.YEAR),
                                    row.getField(CSVHeader.CAR_COLOR),
                                    row.getField(CSVHeader.GENDER),
                                    row.getField(CSVHeader.JOB_TITLE),
                                    row.getField(CSVHeader.BIO)
                                )
                            )
                        }
                    }

            } catch (e: Exception) {
                Log.e("Error",e.printStackTrace().toString())

            }

        }

        return result
    }

}