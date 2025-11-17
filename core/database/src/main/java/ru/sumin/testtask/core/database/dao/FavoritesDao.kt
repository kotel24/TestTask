package ru.sumin.testtask.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sumin.testtask.core.database.model.FavoriteCourseDbModel

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorite_courses")
    fun getFavoriteCourses(): Flow<List<FavoriteCourseDbModel>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_courses WHERE id = :courseId LIMIT 1)")
    fun observeIsFavorite(courseId: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(course: FavoriteCourseDbModel)

    @Query("DELETE FROM favorite_courses WHERE id = :courseId")
    suspend fun removeFromFavorite(courseId: Int)

    @Query("SELECT id FROM favorite_courses")
    suspend fun getFavoriteIds(): List<Int>
}