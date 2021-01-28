package com.a.ali.prayernotifier.model

import com.google.gson.annotations.SerializedName

data class DayData(
    @SerializedName("timings") val timings: Timings,
    @SerializedName("date") val date: Date,
)