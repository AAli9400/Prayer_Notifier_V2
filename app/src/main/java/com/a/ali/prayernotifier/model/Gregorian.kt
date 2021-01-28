package com.a.ali.prayernotifier.model

import com.google.gson.annotations.SerializedName

data class Gregorian(
        @SerializedName("day") val day: Int,
        @SerializedName("weekday") val weekday: Weekday,
        @SerializedName("month") val month: Month,
        @SerializedName("year") val year: Int,
)
