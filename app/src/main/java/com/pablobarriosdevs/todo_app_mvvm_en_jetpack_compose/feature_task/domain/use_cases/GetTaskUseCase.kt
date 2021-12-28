package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class GetTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {

    operator fun invoke(targetDate:Long): Flow<List<Task>> = flow{
        repository.getTasksByDate(targetDate).map {
            it.sortedByDescending { taskInfo ->
                taskInfo.timestamp
            }
        }
    }
}