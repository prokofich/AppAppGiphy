package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FixedWidthDownsampled(
    val height: String,
    val size: String,
    val url: String,
    val webp: String,
    val webp_size: String,
    val width: String
): Parcelable