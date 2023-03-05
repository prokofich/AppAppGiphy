package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GifItem(
    val data: List<Data>,
    val meta: Meta,
    val pagination: Pagination
): Parcelable