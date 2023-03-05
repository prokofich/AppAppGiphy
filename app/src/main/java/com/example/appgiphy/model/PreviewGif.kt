package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PreviewGif(
    val height: String,
    val size: String,
    val url: String,
    val width: String
): Parcelable