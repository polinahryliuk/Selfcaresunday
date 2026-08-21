package com.selfcaresunday.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "log_entries")
data class LogEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val activityId: Int,
    val activityName: String,
    val duration: Int,
    val date: String,
    val timestamp: Long = System.currentTimeMillis(),
    val mood: String? = null,
    val notes: String? = null
)