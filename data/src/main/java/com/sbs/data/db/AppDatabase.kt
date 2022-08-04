package com.sbs.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sbs.data.db.dao.MovieDao
import com.sbs.data.db.entity.MovieEntity

@Database(
    version = 1,
    entities = [MovieEntity::class],
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}