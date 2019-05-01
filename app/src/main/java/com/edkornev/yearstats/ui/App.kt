package com.edkornev.yearstats.ui

import android.app.Application
import androidx.room.Room
import com.edkornev.yearstats.R
import com.edkornev.yearstats.component.DaggerInjector
import com.edkornev.yearstats.component.Injector
import com.edkornev.yearstats.infrastructure.persistance.StatisticDatabase

open class App : Application() {

    lateinit var injector: Injector
        private set

    override fun onCreate() {
        super.onCreate()

        injector = DaggerInjector.builder()
            .database(initDatabase())
            .build()
    }

    protected open fun initDatabase(): StatisticDatabase =
        Room.databaseBuilder(this, StatisticDatabase::class.java, getString(R.string.database_name))
            .fallbackToDestructiveMigration()
            .build()

}