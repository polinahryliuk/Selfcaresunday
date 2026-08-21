package com.selfcaresunday.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activities")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val icon: String,
    val category: String,
    val duration: Int,
    val description: String = "",
    val steps: List<String> = emptyList(),
    val isCustom: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)