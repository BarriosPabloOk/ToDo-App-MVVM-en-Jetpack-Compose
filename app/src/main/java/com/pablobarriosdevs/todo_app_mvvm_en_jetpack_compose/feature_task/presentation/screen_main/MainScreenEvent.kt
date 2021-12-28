package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.presentation.screen_main

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.util.SwipeDirection

sealed class MainScreenEvent{
    data class Swipe(val direction : SwipeDirection): MainScreenEvent()
    data class Delete(val tasks : Task): MainScreenEvent()
    data class Restore(val tasks : Task): MainScreenEvent()
    data class CheckCompleted(val task: Task): MainScreenEvent()
}
