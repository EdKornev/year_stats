package com.edkornev.yearstats.infrastructure.persistance.dao

import androidx.room.*
import com.edkornev.yearstats.infrastructure.persistance.entity.BookEntity
import io.reactivex.Single

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(entity: BookEntity)

    @Update
    fun update(entity: BookEntity): Int

    @Query("DELETE FROM BookEntity WHERE id=:id")
    fun delete(id: String): Int

    @Query("SELECT count(*) FROM BookEntity")
    fun count(): Single<Int>
}