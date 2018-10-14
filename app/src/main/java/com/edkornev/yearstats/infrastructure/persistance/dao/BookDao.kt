package com.edkornev.yearstats.infrastructure.persistance.dao

import androidx.room.*
import com.edkornev.yearstats.infrastructure.persistance.entity.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(entity: BookEntity)

    @Update
    fun update(entity: BookEntity): Int

    @Query("DELETE FROM BookEntity WHERE id=:id")
    fun delete(id: String): Int
}