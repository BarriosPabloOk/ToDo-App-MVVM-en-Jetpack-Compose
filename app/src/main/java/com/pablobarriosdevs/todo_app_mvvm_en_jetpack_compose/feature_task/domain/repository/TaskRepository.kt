package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.repository

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasksByDate(targetDate:Long): Flow<List<Task>>
    suspend fun updateTaskCompleted(taskId : Int, completed: Boolean)
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun searchTasks(query: String): Flow<List<Task>>
}