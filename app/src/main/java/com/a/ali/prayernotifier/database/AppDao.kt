package com.a.ali.prayernotifier.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.a.ali.prayernotifier.model.DayDatabaseModel
import java.util.*

@Dao
abstract class AppDao {
    @Query("SELECT COUNT(*) FROM DayDatabaseModel WHERE gregorianDateNumber = :gregorianDateNumber LIMIT 1")
    protected abstract suspend fun dayExists(gregorianDateNumber: Int): Int

    @Query("SELECT * FROM DayDatabaseModel WHERE dayOfMonth = :dayOfMonth LIMIT 1")
    abstract fun get(dayOfMonth: String):  LiveData<DayDatabaseModel?>

    fun getDayData(): LiveData<DayDatabaseModel?> {
        val calender = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
        }

        //get day of month in string format of dd. example: 01
        val dayOfMonth = calender.get(Calendar.DAY_OF_MONTH)
        var dayOfMonthString = "$dayOfMonth"
        if (dayOfMonthString.length == 1) dayOfMonthString = "0$dayOfMonthString"

        return get(dayOfMonthString)
    }

    suspend fun monthHasLocalData(): Boolean {
        val calender = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
        }

        return dayExists(calender.get(Calendar.MONTH) + 1) > 0
    }

    suspend fun insertMonthData(monthData: List<DayDatabaseModel>) {
        //clear all saved data in the database
        clear()
        insert(monthData)
    }

    @Insert
    protected abstract suspend fun insert(dayDatabaseModel: List<DayDatabaseModel>)

    @Query("DELETE FROM DayDatabaseModel")
    abstract suspend fun clear()
}