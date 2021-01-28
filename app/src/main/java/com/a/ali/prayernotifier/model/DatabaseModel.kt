package com.a.ali.prayernotifier.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.a.ali.prayernotifier.api.ApiConstants

@Entity
data class DatabaseModel(
        val fajr: String,
        val sunrise: String,
        val dhuhr: String,
        val asr: String,
        val maghrib: String,
        val isha: String,
        val gregorianDateEN: String,
        val gregorianDateAR: String,
        val hijriDateEN: String,
        val hijriDateAR: String,

        @PrimaryKey(autoGenerate = true)
        val id: Int = 0
) {
    constructor(dayData: DayData) : this(
            fajr = dayData.timings.fajr,
            sunrise = dayData.timings.sunrise,
            dhuhr = dayData.timings.dhuhr,
            asr = dayData.timings.asr,
            maghrib = dayData.timings.maghrib,
            isha = dayData.timings.isha,
            gregorianDateEN = dayData.date.gregorian.month.en,
            gregorianDateAR = ApiConstants.GregorianMonth.getMonthNameAR(dayData.date.gregorian.month.number),
            hijriDateEN = dayData.date.hijri.month.en,
            hijriDateAR = dayData.date.hijri.month.ar
    )
}
