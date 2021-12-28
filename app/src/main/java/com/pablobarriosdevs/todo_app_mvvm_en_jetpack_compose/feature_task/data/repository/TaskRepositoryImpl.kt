package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.data.repository

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.data.local.TaskDao
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val dao : TaskDao
) : TaskRepository {

    override fun getTasksByDate(targetDate: Long): Flow<List<Task>> {
        return dao.getTasksByDate(targetDate)
    }

    override suspend fun updateTaskCompleted(taskId: Int, completed: Boolean) {
        dao.updateTaskCompleted(taskId, completed)
    }

    override suspend fun insertTask(task: Task) {
        dao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(task)
    }

    override suspend fun searchTasks(query: String): Flow<List<Task>> {
        return dao.searchTasks(query)
    }
}