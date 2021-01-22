package dev.smoketrees.nasa_apod.utils

import dev.smoketrees.nasa_apod.data.model.ApodItem
import org.junit.Test
import kotlin.test.assertEquals

class ApodItemComparatorTest {
    private val smallerItem = ApodItem(
        copyright = "Example.Inc",
        date = "2021-01-22",
        explanation = "Test item",
        hdUrl = "https://example.com/hd",
        mediaType = "image",
        serviceVersion = "v1",
        title = "Test item",
        url = "https://example.com"
    )

    private val largerItem = ApodItem(
        copyright = "Example.Inc",
        date = "2021-01-23",
        explanation = "Test item",
        hdUrl = "https://example.com/hd",
        mediaType = "image",
        serviceVersion = "v1",
        title = "Test item",
        url = "https://example.com"
    )

    @Test
    fun `finds newer picture to be smaller`() {
        assertEquals(-1, ApodItemComparator.compare(largerItem, smallerItem))
    }

    @Test
    fun `finds older picture to be larger`() {
        assertEquals(1, ApodItemComparator.compare(smallerItem, largerItem))
    }

    @Test
    fun `finds same picture to be equal`() {
        assertEquals(0, ApodItemComparator.compare(smallerItem, smallerItem))
        assertEquals(0, ApodItemComparator.compare(largerItem, largerItem))
    }
}