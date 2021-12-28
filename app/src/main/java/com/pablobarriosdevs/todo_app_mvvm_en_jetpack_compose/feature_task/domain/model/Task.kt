package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val id : Int?,
    val title : String,
    val timestamp: Long,
    val targetDate : Long,
    val isCompleted : Boolean,
)
