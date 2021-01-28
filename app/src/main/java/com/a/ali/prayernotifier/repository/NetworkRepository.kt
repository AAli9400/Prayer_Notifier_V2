package com.a.ali.prayernotifier.repository

import androidx.lifecycle.LiveData
import com.a.ali.prayernotifier.api.ApiConstants
import com.a.ali.prayernotifier.model.MonthData
import com.a.ali.prayernotifier.network.ApiService
import com.a.ali.prayernotifier.network.response.AppRetrofitRequest
import com.a.ali.prayernotifier.network.response.AppRetrofitResponse
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.Url.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

    private val apiService: ApiService

    init {
        apiService = retrofit.create(ApiService::class.java)
    }

    fun loadMonthData(): LiveData<AppRetrofitResponse<MonthData>> {
        return AppRetrofitRequest<MonthData>().makeRequest { apiService.loadMonthData() }
    }
}