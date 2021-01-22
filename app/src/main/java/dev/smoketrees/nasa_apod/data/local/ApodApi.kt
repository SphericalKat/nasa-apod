package dev.smoketrees.nasa_apod.data.local

import android.content.Context
import com.squareup.moshi.JsonAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.smoketrees.nasa_apod.R
import dev.smoketrees.nasa_apod.data.model.ApodItem
import javax.inject.Inject

class ApodApi @Inject constructor(
    @ApplicationContext private val context: Context,
    private val jsonAdapter: JsonAdapter<List<ApodItem>>
) {
    fun getApodItems(): List<ApodItem> {
        val res = context.resources.openRawResource(R.raw.data)
        val jsonString = res.bufferedReader().use { it.readText() }
        return jsonAdapter.fromJson(jsonString) ?: error("Failed to parse JSON")
    }
}