package com.edkornev.yearstats.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.edkornev.yearstats.infrastructure.persistance.dao.BookDao

class BookAddViewModelFactory(
    private val dao: BookDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(BookAddViewModel::class.java) -> BookAddViewModel(dao) as T
            else -> throw IllegalArgumentException("BookAddViewModelFactory doesn't support this view model: ${modelClass.canonicalName}")
        }

}