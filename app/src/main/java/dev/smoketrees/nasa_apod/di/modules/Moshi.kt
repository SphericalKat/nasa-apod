package dev.smoketrees.nasa_apod.di.modules

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.smoketrees.nasa_apod.data.model.ApodItem

@Module
@InstallIn(ApplicationComponent::class)
object MoshiModule {
    @Provides
    fun providesMoshi() = Moshi.Builder().build()

    @Provides
    fun providesApodItemJsonAdapter(moshi: Moshi): JsonAdapter<List<ApodItem>> {
        val listOfApodItemType = Types.newParameterizedType(List::class.java, ApodItem::class.java)
        return moshi.adapter<List<ApodItem>>(listOfApodItemType).failOnUnknown()
    }
}