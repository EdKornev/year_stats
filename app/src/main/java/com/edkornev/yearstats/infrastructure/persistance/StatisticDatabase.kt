package com.edkornev.yearstats.infrastructure.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edkornev.yearstats.BuildConfig
import com.edkornev.yearstats.infrastructure.persistance.dao.BookDao
import com.edkornev.yearstats.infrastructure.persistance.entity.BookEntity

@Database(
        entities = [
            BookEntity::class
        ],
        version = BuildConfig.DATABASE_VERSION
)
abstract class StatisticDatabase : RoomDatabase() {

    abstract fun getBookDao(): BookDao
}