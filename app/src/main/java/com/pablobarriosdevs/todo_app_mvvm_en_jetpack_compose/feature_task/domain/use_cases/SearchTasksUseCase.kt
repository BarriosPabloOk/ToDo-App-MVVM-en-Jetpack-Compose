package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class SearchTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(query:String): Flow<List<Task>> = flow {
        repository.searchTasks(query).map {
            it.sortedByDescending { taskInfo ->
                taskInfo.title.lowercase()
            }
        }
    }
}