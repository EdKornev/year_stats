package com.edkornev.yearstats.component.book

import androidx.lifecycle.ViewModelProvider
import com.edkornev.yearstats.infrastructure.persistance.StatisticDatabase
import com.edkornev.yearstats.ui.book.BookAddViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BookAddModule {

    @Provides
    fun provideViewModel(database: StatisticDatabase): ViewModelProvider.Factory =
        BookAddViewModelFactory(database.getBookDao())

}