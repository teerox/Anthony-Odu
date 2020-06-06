package com.example.anthonyodu

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.anthonyodu.FakeData
import com.example.anthonyodu.model.Filter
import com.example.anthonyodu.utils.Utility

import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class FilterTest {

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")
    private val carOwners = FakeData.arrayCarOwner
    private val filterArray = FakeData.arrayFilter

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp(){
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun filter_should_return_correct_list_size_where_color_gender_and_country_match(){
        runBlocking {
            launch(Dispatchers.Main) {
                val myFilterFunction = Utility
                val filter = filterArray[0]
                val filteredList =  myFilterFunction.filter(carOwners,filter)
                Assert.assertEquals(1, filteredList.size)
            }

        }
    }



    @ExperimentalCoroutinesApi
    @Test
    fun filter_should_return_correct_list_size_for_no_match_filter(){
        runBlocking {
            launch(Dispatchers.Main) {
                val myFilterFunction = Utility
                val filter = filterArray[1]
                val filteredList =  myFilterFunction.filter(carOwners,filter)
                Assert.assertEquals(0, filteredList.size)
            }

        }
    }


    @ExperimentalCoroutinesApi
    @Test
    fun filter_should_return_correct_list_size_for_no_gender_and_no_color(){
        runBlocking {
            launch(Dispatchers.Main) {
                val myFilterFunction = Utility
                val filter = filterArray[2]
                val filteredList =  myFilterFunction.filter(carOwners,filter)
                Assert.assertEquals(3, filteredList.size)
            }

        }
    }



}