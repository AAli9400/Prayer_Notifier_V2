package com.a.ali.prayernotifier.model

import com.a.ali.prayernotifier.model.DayData
import com.google.gson.annotations.SerializedName

data class MonthData(
        @SerializedName("data") val data: List<DayData>
)