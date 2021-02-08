package dev.smoketrees.nasa_apod.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.smoketrees.nasa_apod.data.local.ApodApi
import dev.smoketrees.nasa_apod.data.model.ApodItem
import dev.smoketrees.nasa_apod.utils.ApodItemComparator

class MainViewModel @ViewModelInject constructor(apodApi: ApodApi) : ViewModel() {
    var apodItems: MutableLiveData<List<ApodItem>> =
        MutableLiveData(apodApi.getApodItems().sortedWith(ApodItemComparator))
}