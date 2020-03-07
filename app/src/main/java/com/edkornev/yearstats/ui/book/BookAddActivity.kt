package com.edkornev.yearstats.ui.book

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.edkornev.yearstats.R
import com.edkornev.yearstats.databinding.BookAddActivityBinding
import com.edkornev.yearstats.ui.App
import javax.inject.Inject

class BookAddActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, BookAddActivity::class.java)
    }

    @Inject protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: BookAddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injector
            .plusBookAddComponent()
            .build()
            .inject(this)

        viewModel = viewModelFactory.create(BookAddViewModel::class.java)

        val binding: BookAddActivityBinding = DataBindingUtil.setContentView(this, R.layout.book_add_activity)
        binding.book = viewModel
    }
}