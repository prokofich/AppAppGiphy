package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DownsizedSmall(
    val height: String,
    val mp4: String,
    val mp4_size: String,
    val width: String
): Parcelable