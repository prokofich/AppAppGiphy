package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meta(
    val msg: String,
    val response_id: String,
    val status: Int
): Parcelable