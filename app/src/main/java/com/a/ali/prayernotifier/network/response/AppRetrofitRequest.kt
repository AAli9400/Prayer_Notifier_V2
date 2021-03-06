package com.a.ali.prayernotifier.network.response

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call

class AppRetrofitRequest<T> {
    fun makeRequest(request: () -> Call<T>): LiveData<AppRetrofitResponse<T>> =
        MutableLiveData<AppRetrofitResponse<T>>().also {
            request().enqueue(AppRetrofitCallback(it))
        }
}