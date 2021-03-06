package com.a.ali.prayernotifier

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.ali.prayernotifier.repository.DatabaseRepository

class MainViewModelFactory(
    private val databaseRepository: DatabaseRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(databaseRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}