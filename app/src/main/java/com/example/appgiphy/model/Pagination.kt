package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pagination(
    val count: Int,
    val offset: Int,
    val total_count: Int
): Parcelable