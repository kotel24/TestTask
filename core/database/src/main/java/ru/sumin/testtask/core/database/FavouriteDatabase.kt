package ru.sumin.testtask.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.sumin.testtask.core.database.dao.FavoritesDao
import ru.sumin.testtask.core.database.model.FavoriteCourseDbModel

@Database(
    entities = [FavoriteCourseDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class FavouriteDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao
}