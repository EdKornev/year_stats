package com.edkornev.yearstats.component.review

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.edkornev.yearstats.infrastructure.persistance.StatisticDatabase
import com.edkornev.yearstats.ui.review.ReviewViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ReviewModule {

    @Provides
    fun provideViewModel(
        database: StatisticDatabase,
        context: Context
    ): ViewModelProvider.Factory =
        ReviewViewModelFactory(context, database.getBookDao())

}