package com.edkornev.yearstats.component

import com.edkornev.yearstats.component.book.BookAddComponent
import com.edkornev.yearstats.component.review.ReviewComponent
import com.edkornev.yearstats.infrastructure.persistance.StatisticDatabase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface Injector {

    fun plusBookAddComponent(): BookAddComponent.Builder
    fun plusReviewComponent(): ReviewComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): Injector
        @BindsInstance fun database(database: StatisticDatabase): Builder
    }

}