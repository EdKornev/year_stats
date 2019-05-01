package com.edkornev.yearstats.component.book

import com.edkornev.yearstats.ui.book.BookAddActivity
import dagger.Subcomponent

@Subcomponent(modules = [BookAddModule::class])
interface BookAddComponent {

    fun inject(activity: BookAddActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): BookAddComponent
    }
}