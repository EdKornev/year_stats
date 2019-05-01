package com.edkornev.yearstats.ui.book

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.edkornev.yearstats.infrastructure.persistance.dao.BookDao
import com.edkornev.yearstats.infrastructure.persistance.entity.BookEntity

class BookAddViewModel(
    private val dao: BookDao
) : ViewModel() {

    val title = ObservableField<String>()
    val author = ObservableField<String>()
    val genre = ObservableField<String>()

    var isLoading: Boolean = false

    fun save() {
        val title = this.title.get() ?: ""
        val author = this.author.get() ?: ""

        BookEntity(
            id = "id",
            title = title,
            author = author
        ).let(dao::save)

        Log.w("BookAddViewModel", "title: $title; author: $author; genre: ${genre.get()};")
    }

}