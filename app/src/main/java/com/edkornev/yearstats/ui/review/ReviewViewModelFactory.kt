package com.edkornev.yearstats.ui.review

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edkornev.yearstats.infrastructure.persistance.dao.BookDao

class ReviewViewModelFactory(
    private val context: Context,
    private val dao: BookDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(ReviewViewModel::class.java) -> ReviewViewModel(context, dao) as T
            else -> throw IllegalArgumentException("ReviewViewModelFactory doesn't support this view model: ${modelClass.canonicalName}")
        }

}