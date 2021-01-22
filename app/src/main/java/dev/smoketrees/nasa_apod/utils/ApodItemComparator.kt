package dev.smoketrees.nasa_apod.utils

import dev.smoketrees.nasa_apod.data.model.ApodItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ApodItemComparator : Comparator<ApodItem> {
    override fun compare(o1: ApodItem, o2: ApodItem): Int {
        val date1 = LocalDate.parse(o1.date, DateTimeFormatter.ISO_DATE)
        val date2 = LocalDate.parse(o2.date, DateTimeFormatter.ISO_DATE)
        return when {
            date1.isAfter(date2) -> -1
            date2.isAfter(date1) -> 1
            else -> 0
        }
    }
}