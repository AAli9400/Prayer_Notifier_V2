package com.a.ali.prayernotifier.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.a.ali.prayernotifier.api.ApiConstants.GregorianMonth.getMonthNameAR

@Entity
data class DayDatabaseModel(
        val fajr: String,
        val sunrise: String,
        val dhuhr: String,
        val asr: String,
        val maghrib: String,
        val isha: String,
        val gregorianDateEN: String,
        val gregorianDateAR: String,
        val gregorianDateNumber: Int,
        val hijriDateEN: String,
        val hijriDateAR: String,
        val dayNameEN: String,
        val dayNameAR: String,
        val dayOfMonth : String,

        @PrimaryKey(autoGenerate = true)
        val id: Int = 0
) {
    constructor(day: Day) : this(
            fajr = day.timings.fajr.removeSuffix(" (EET)"),
            sunrise = day.timings.sunrise.removeSuffix(" (EET)"),
            dhuhr = day.timings.dhuhr.removeSuffix(" (EET)"),
            asr = day.timings.asr.removeSuffix(" (EET)"),
            maghrib = day.timings.maghrib.removeSuffix(" (EET)"),
            isha = day.timings.isha.removeSuffix(" (EET)"),
            gregorianDateEN = "${day.date.gregorian.day} ${day.date.gregorian.month.en} ${day.date.gregorian.year}",
            gregorianDateAR = "${day.date.gregorian.day} ${getMonthNameAR(day.date.gregorian.month.number)} ${day.date.gregorian.year}",
            gregorianDateNumber = day.date.gregorian.month.number,
            hijriDateEN = "${day.date.hijri.day} ${day.date.hijri.month.en} ${day.date.hijri.year}",
            hijriDateAR = "${day.date.hijri.day} ${day.date.hijri.month.ar} ${day.date.hijri.year}",
            dayNameEN = day.date.gregorian.weekday.en,
            dayNameAR = day.date.hijri.weekday.ar,
            dayOfMonth = day.date.gregorian.day
    )
}
