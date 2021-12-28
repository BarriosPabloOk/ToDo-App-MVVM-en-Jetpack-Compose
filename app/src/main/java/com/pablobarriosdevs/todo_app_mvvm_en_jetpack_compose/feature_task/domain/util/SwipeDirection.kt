package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.util

enum class SwipeDirection (eventType : Int) {
    SWIPE_LEFT(-1),
    SWIPE_RIGHT(1),
    SWIPE_VERTICAL(0)
}