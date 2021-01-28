package com.a.ali.prayernotifier.api

object ApiConstants {
    object Url {
        const val BASE_URL = "http://api.aladhan.com/v1/calendarByCity/"
        const val BASE_URL_FOR_GET_METHOD = "http://api.aladhan.com/v1/calendarByCity"
    }

    object Parameter {
        const val CITY_PARAM_NAME = "city"
        const val COUNTRY_PARAM_NAME = "country"
        const val METHOD_PARAM_NAME = "method"
    }

    object EgyptParametersValues {
        const val CAIRO = "Cairo"
        const val EGYPT = "Egypt"
        const val EGYPTIAN_GENERAL_AUTHORITY_OF_SURVEY_METHOD = 5
    }

    object GregorianMonth {
        private const val JANUARY_AR = "يناير"
        private const val FEBRUARY_AR = "يناير"
        private const val MARCH_AR = "يناير"
        private const val APRIL_AR = "يناير"
        private const val MAY_AR = "يناير"
        private const val JUNE_AR = "يناير"
        private const val JULY_AR = "يناير"
        private const val AUGUST_AR = "يناير"
        private const val SEPTEMBER_AR = "يناير"
        private const val OCTOBER_AR = "يناير"
        private const val NOVEMBER_AR = "يناير"
        private const val DECEMBER_AR = "يناير"

        fun getMonthNameAR(monthNum: Int) = when (monthNum) {
            1 -> JANUARY_AR
            2 -> FEBRUARY_AR
            3 -> MARCH_AR
            4 -> APRIL_AR
            5 -> MAY_AR
            6 -> JUNE_AR
            7 -> JULY_AR
            8 -> AUGUST_AR
            9 -> SEPTEMBER_AR
            10 -> OCTOBER_AR
            11 -> NOVEMBER_AR
            else -> DECEMBER_AR
        }
    }
}