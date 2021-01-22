package dev.smoketrees.nasa_apod.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Represents a single element of the APOD data
 */
@JsonClass(generateAdapter = true)
data class ApodItem(
    val copyright: String? = null,
    val date: String,
    val explanation: String,
    @Json(name = "hdurl")
    val hdUrl: String,
    @Json(name = "media_type")
    val mediaType: String,
    @Json(name = "service_version")
    val serviceVersion: String,
    val title: String,
    val url: String
) : java.io.Serializable