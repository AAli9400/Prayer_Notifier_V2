package com.a.ali.prayernotifier.network

import com.a.ali.prayernotifier.api.ApiConstants
import com.a.ali.prayernotifier.api.ApiConstants.EgyptParametersValues.EGYPT
import com.a.ali.prayernotifier.api.ApiConstants.EgyptParametersValues.EGYPTIAN_GENERAL_AUTHORITY_OF_SURVEY_METHOD
import com.a.ali.prayernotifier.api.ApiConstants.Parameter.CITY_PARAM_NAME
import com.a.ali.prayernotifier.api.ApiConstants.Parameter.COUNTRY_PARAM_NAME
import com.a.ali.prayernotifier.api.ApiConstants.Parameter.METHOD_PARAM_NAME
import com.a.ali.prayernotifier.api.ApiConstants.Url.BASE_URL_FOR_GET_METHOD
import com.a.ali.prayernotifier.model.MonthData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(BASE_URL_FOR_GET_METHOD)
    fun loadMonthData(
        @Query(CITY_PARAM_NAME) city: String = ApiConstants.EgyptParametersValues.CAIRO,
        @Query(COUNTRY_PARAM_NAME) country: String = EGYPT,
        @Query(METHOD_PARAM_NAME) method: Int = EGYPTIAN_GENERAL_AUTHORITY_OF_SURVEY_METHOD
    ): Call<MonthData>
}