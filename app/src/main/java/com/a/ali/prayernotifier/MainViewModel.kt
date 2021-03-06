package com.a.ali.prayernotifier

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a.ali.prayernotifier.model.Day
import com.a.ali.prayernotifier.model.DayDatabaseModel
import com.a.ali.prayernotifier.repository.DatabaseRepository
import com.a.ali.prayernotifier.repository.NetworkRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val databaseRepository: DatabaseRepository,
) : ViewModel() {
    private val dayDataLiveData: LiveData<DayDatabaseModel?> by lazy { getDayData() }

    private fun getDayData(): LiveData<DayDatabaseModel?> = databaseRepository.getDayData()

    fun refreshMonthDataDFromTheNetwork() = NetworkRepository.loadMonthData()

    fun getMonthData() = dayDataLiveData

    fun insertMonthData(data: List<Day>) = viewModelScope.launch {
        val monthData = ArrayList<DayDatabaseModel>()
        data.forEach { day: Day ->
            monthData.add(DayDatabaseModel(day))
        }

        //insert the new data to the database
        databaseRepository.insertMonthData(monthData)
    }
}