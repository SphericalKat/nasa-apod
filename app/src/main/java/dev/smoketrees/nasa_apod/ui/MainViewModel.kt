package dev.smoketrees.nasa_apod.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.smoketrees.nasa_apod.data.local.ApodApi

class MainViewModel @ViewModelInject constructor(apodApi: ApodApi) : ViewModel() {
    val apodItems = apodApi.getApodItems()
}