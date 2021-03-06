package com.a.ali.prayernotifier.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.a.ali.prayernotifier.database.AppDao
import com.a.ali.prayernotifier.database.AppDatabase
import com.a.ali.prayernotifier.model.DayDatabaseModel

class DatabaseRepository private constructor(private val context: Context) {
    private val appDao: AppDao by lazy {
        AppDatabase.getInstance(context).appDao()
    }

     fun getDayData(): LiveData<DayDatabaseModel?> = appDao.getDayData()

    suspend fun monthHasLocalData() = appDao.monthHasLocalData()

    suspend fun insertMonthData(monthData: List<DayDatabaseModel>) = appDao.insertMonthData(monthData)

    companion object {
        @Volatile
        private var INSTANCE: DatabaseRepository? = null

        fun getInstance(context: Context): DatabaseRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE = DatabaseRepository(context)
                INSTANCE
            }!!
        }
    }
}