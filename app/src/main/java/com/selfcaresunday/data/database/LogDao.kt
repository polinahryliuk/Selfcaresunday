package com.selfcaresunday.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.selfcaresunday.data.model.LogEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface LogDao {
    @Query("SELECT * FROM log_entries ORDER BY timestamp DESC")
    fun getAllLogs(): Flow<List<LogEntry>>

    @Query("SELECT * FROM log_entries WHERE date = :date")
    fun getLogsByDate(date: String): Flow<List<LogEntry>>

    @Query("SELECT * FROM log_entries WHERE activityId = :activityId")
    fun getLogsByActivity(activityId: Int): Flow<List<LogEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLog(log: LogEntry)

    @Query("SELECT COUNT(*) FROM log_entries WHERE date = :date")
    suspend fun getLogCountForDate(date: String): Int

    @Query("SELECT SUM(duration) FROM log_entries WHERE date = :date")
    suspend fun getTotalMinutesForDate(date: String): Int?

    @Query("SELECT COUNT(DISTINCT date) FROM log_entries WHERE date >= date('now', '-6 days')")
    suspend fun getCurrentStreak(): Int
}