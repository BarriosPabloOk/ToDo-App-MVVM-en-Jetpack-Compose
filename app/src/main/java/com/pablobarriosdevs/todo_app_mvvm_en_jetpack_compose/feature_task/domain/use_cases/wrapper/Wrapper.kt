package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases.wrapper

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases.*

data class Wrapper(
    val getTaskUseCase: GetTaskUseCase,
    val updateTaskUseCase: UpdateTaskUseCase,
    val insertTaskUseCase: InsertTaskUseCase,
    val deleteUseCase: DeleteUseCase,
    val searchTasksUseCase: SearchTasksUseCase,
    val setDateUseCase: SetDateUseCase,
)
