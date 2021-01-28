package com.a.ali.prayernotifier.model

import com.google.gson.annotations.SerializedName

data class Date(
        @SerializedName("readable") val readable: String,
        @SerializedName("gregorian") val gregorian: Gregorian,
        @SerializedName("hijri") val hijri: Hijri
)
