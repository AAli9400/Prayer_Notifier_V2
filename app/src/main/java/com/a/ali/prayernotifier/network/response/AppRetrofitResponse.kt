package com.a.ali.prayernotifier.network.response

import retrofit2.Response

data class AppRetrofitResponse<T>(
    var state: STATE = STATE.LOADING,
    val response: Response<T>? = null,
    val throwable: Throwable? = null
) {
    enum class STATE {
        LOADING, SUCCESS, ERROR
    }
}
