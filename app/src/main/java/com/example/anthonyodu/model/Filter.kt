package com.example.anthonyodu.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

typealias FilterArray = ArrayList<Filter>


@Parcelize
data class Filter (
    val colors: List<String>,
    val countries: List<String>,
    val end_year: Int,
    val gender: String,
    val id: Int,
    val start_year: Int
):Parcelable
