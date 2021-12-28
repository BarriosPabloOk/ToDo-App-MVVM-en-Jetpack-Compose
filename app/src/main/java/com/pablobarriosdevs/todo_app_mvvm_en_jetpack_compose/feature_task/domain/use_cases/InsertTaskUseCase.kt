package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.repository.TaskRepository
import javax.inject.Inject


class InsertTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {

    suspend operator fun invoke(task: Task){
        repository.insertTask(task)
    }
}