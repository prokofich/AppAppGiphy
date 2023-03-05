package com.example.appgiphy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Analytics(
    val onclick: Onclick,
    val onload: Onload,
    val onsent: Onsent
):Parcelable