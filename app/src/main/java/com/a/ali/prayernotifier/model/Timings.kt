package com.a.ali.prayernotifier.model

import com.google.gson.annotations.SerializedName

data class Timings(
        @SerializedName("Fajr") val fajr: String,
        @SerializedName("Sunrise") val sunrise: String,
        @SerializedName("Dhuhr") val dhuhr: String,
        @SerializedName("Asr") val asr: String,
        @SerializedName("Maghrib") val maghrib: String,
        @SerializedName("Isha") val isha: String,
)
