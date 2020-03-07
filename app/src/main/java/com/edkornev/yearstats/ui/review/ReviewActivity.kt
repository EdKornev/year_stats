package com.edkornev.yearstats.ui.review

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.edkornev.yearstats.R
import com.edkornev.yearstats.databinding.ReviewActivityBinding
import com.edkornev.yearstats.ui.App
import javax.inject.Inject

class ReviewActivity : AppCompatActivity() {

    @Inject lateinit var viewModelProvider: ViewModelProvider.Factory
    private lateinit var viewModel: ReviewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).injector
            .plusReviewComponent()
            .context(application)
            .build()
            .inject(this)

        viewModel = viewModelProvider.create(ReviewViewModel::class.java)

        val binding: ReviewActivityBinding = DataBindingUtil.setContentView(this, R.layout.review_activity)
        binding.review = viewModel
    }

    override fun onStart() {
        super.onStart()

        viewModel.onStart()
    }
}
