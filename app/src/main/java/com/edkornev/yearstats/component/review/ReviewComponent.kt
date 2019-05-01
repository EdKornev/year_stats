package com.edkornev.yearstats.component.review

import android.content.Context
import com.edkornev.yearstats.ui.review.ReviewActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ReviewModule::class])
interface ReviewComponent {

    fun inject(activity: ReviewActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ReviewComponent
        @BindsInstance fun context(context: Context): Builder
    }

}