package com.a.ali.prayernotifier.network.response

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRetrofitCallback<T>(private val liveData: MutableLiveData<AppRetrofitResponse<T>>) : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        liveData.postValue(AppRetrofitResponse(AppRetrofitResponse.STATE.SUCCESS, response = response))
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        liveData.postValue(AppRetrofitResponse(AppRetrofitResponse.STATE.ERROR, throwable = t))
    }
}