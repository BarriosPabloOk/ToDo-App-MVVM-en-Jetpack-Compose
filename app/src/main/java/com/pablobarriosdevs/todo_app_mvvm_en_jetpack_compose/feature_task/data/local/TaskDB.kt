package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDB : RoomDatabase() {

    abstract val dao : TaskDao

    companion object{
        const val DATABASE_NAME = "task_db"
    }
}