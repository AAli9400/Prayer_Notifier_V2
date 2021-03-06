package com.a.ali.prayernotifier

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.a.ali.prayernotifier.databinding.ActivityMainBinding
import com.a.ali.prayernotifier.network.response.AppRetrofitResponse.STATE.*
import com.a.ali.prayernotifier.repository.DatabaseRepository
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val databaseRepository = DatabaseRepository.getInstance(this)
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //set content view of the activity to the root of the inflated binding
        setContentView(binding.root)

        //init viewmodel
        val mainViewModelFactory = MainViewModelFactory(databaseRepository)
        viewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        //check if this month has data in the database
        refreshMonthDataIfRequired()
    }

    private fun refreshMonthDataIfRequired() = CoroutineScope(Dispatchers.IO).launch {
        val shouldRefreshMonthData = !databaseRepository.monthHasLocalData()

        withContext(Dispatchers.Main) {
            if (shouldRefreshMonthData) {
                viewModel.refreshMonthDataDFromTheNetwork().observe(this@MainActivity, {
                    when (it.state) {
                        LOADING -> binding.progressBar.show()

                        SUCCESS -> viewModel.insertMonthData(it.response!!.body()!!.data)
                            .invokeOnCompletion { observerDayDataFromTheDatabase() }

                        ERROR -> {
                            //hide loading view
                            binding.progressBar.hide()

                            //show error message
                            showToast(it.throwable?.message)

                            //observer day data from the database
                            observerDayDataFromTheDatabase()
                        }
                    }
                })
            } else observerDayDataFromTheDatabase()
        }
    }

    private fun observerDayDataFromTheDatabase() {
        viewModel.getMonthData().observe(this@MainActivity, {
            //set day data to the view
            binding.day = it

            if (it == null) {
                showToast("Can't Load Day Data !")

                //hide loading view
                binding.progressBar.hide()
            }
        })
    }

    private fun View.hide() {
        visibility = GONE
    }

    private fun View.show() {
        visibility = VISIBLE
    }

    private fun showToast(message: String?) {
        message?.let { Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show() }
    }
}