package com.edkornev.yearstats.ui.review

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edkornev.yearstats.R
import com.edkornev.yearstats.infrastructure.persistance.dao.BookDao
import com.edkornev.yearstats.ui.book.BookAddActivity

private const val HARDCODE_COUNT_BOOK = 20

class ReviewViewModel(
    private val context: Context,
    private val dao: BookDao
) : ViewModel() {

    val countBooks: LiveData<Int> = MutableLiveData()
    val count = ObservableField<String>()

    init {
        count.set(context.getString(R.string.review_count_of_book, HARDCODE_COUNT_BOOK))
    }

    fun openAddBookScreen() {
        context.startActivity(BookAddActivity.createIntent(context))
    }

}