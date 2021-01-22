package dev.smoketrees.nasa_apod.di.modules

import com.squareup.moshi.JsonAdapter
import dev.smoketrees.nasa_apod.data.model.ApodItem
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.fail

class JsonAdapterTest {
    private val jsonAdapter: JsonAdapter<List<ApodItem>>

    private fun loadJson(): String {
        val uri = javaClass.classLoader?.getResource("data.json") ?: error("Failed to load JSON")
        return String(File(uri.path).readBytes())
    }

    @Test
    fun `parses json correctly`() {
        val items = jsonAdapter.fromJson(loadJson()) ?: fail("Failed to parse JSON")
        assertEquals(2, items.size)
        assertNull(items[0].copyright)
        assertNotNull(items[1].copyright)
        assertEquals("N63A: Supernova Remnant in Visible and X-ray", items[0].title)
        assertEquals("Decorating the Sky", items[1].title)
    }

    init {
        val moshi = MoshiModule.providesMoshi()
        jsonAdapter = MoshiModule.providesApodItemJsonAdapter(moshi)
    }
}