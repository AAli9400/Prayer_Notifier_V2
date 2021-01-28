package com.a.ali.prayernotifier.model

import com.google.gson.annotations.SerializedName

data class Weekday(
        @SerializedName("en") val en: String,
        @SerializedName("ar") val ar: String
)
