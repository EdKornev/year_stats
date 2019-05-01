package com.edkornev.yearstats.ui.review

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.edkornev.yearstats.R
import com.edkornev.yearstats.databinding.ReviewActivityBinding
import com.edkornev.yearstats.ui.App
import javax.inject.Inject

class ReviewActivity : AppCompatActivity() {

    @Inject lateinit var viewModelProvider: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injector
            .plusReviewComponent()
            .context(application)
            .build()
            .inject(this)

        val viewModel = ViewModelProviders.of(this, viewModelProvider)[ReviewViewModel::class.java]

        val binding: ReviewActivityBinding = DataBindingUtil.setContentView(this, R.layout.review_activity)
        binding.review = viewModel
    }
}
