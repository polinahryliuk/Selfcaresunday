package com.selfcaresunday.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.selfcaresunday.data.model.Activity
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {
    @Query("SELECT * FROM activities ORDER BY name ASC")
    fun getAllActivities(): Flow<List<Activity>>

    @Query("SELECT * FROM activities WHERE id = :id")
    fun getActivityById(id: Int): Flow<Activity?>

    @Query("SELECT * FROM activities WHERE category = :category")
    fun getActivitiesByCategory(category: String): Flow<List<Activity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(activity: Activity)

    @Update
    suspend fun updateActivity(activity: Activity)

    @Delete
    suspend fun deleteActivity(activity: Activity)

    @Query("DELETE FROM activities WHERE id = :id")
    suspend fun deleteActivityById(id: Int)
}