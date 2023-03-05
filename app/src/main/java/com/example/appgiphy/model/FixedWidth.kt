package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FixedWidth(
    val height: String,
    val mp4: String,
    val mp4_size: String,
    val size: String,
    val url: String,
    val webp: String,
    val webp_size: String,
    val width: String
): Parcelable