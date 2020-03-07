package com.edkornev.yearstats.ui.review

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edkornev.yearstats.R
import com.edkornev.yearstats.infrastructure.persistance.dao.BookDao
import com.edkornev.yearstats.ui.book.BookAddActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ReviewViewModel(
    private val context: Context,
    private val dao: BookDao
) : ViewModel() {

    val count = ObservableField<String>()

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val countBooks: MutableLiveData<Int> = MutableLiveData()

    init {
        // empty
    }

    fun onStart() {
        dao.count()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { count -> this.count.set(context.getString(R.string.review_count_of_book, count)) },
                { error ->  }
            )
            .let(disposables::add)
    }

    fun openAddBookScreen() {
        context.startActivity(BookAddActivity.createIntent(context))
    }

    override fun onCleared() {
        if (!disposables.isDisposed) {
            disposables.clear()
        }

        super.onCleared()
    }

}