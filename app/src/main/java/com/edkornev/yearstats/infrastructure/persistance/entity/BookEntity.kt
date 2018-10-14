package com.edkornev.yearstats.infrastructure.persistance.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BookEntity.TABLE_NAME)
class BookEntity(
        @PrimaryKey
        val id: String,
        val title: String,
        val author: String
) {
    companion object {
        const val TABLE_NAME = "BookEntity"
    }
}