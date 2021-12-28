package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases

import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.util.SwipeDirection
import java.util.*
import javax.inject.Inject


class SetDateUseCase @Inject constructor(
    private val currentDate: Date
) {

    operator fun invoke(
        cal: Calendar,
        swipeDirection: SwipeDirection
    ): Date {

        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)

        when (swipeDirection) {
            SwipeDirection.SWIPE_LEFT -> {
                cal.add(Calendar.DAY_OF_MONTH, -1)
            }
            SwipeDirection.SWIPE_RIGHT -> {
                cal.add(Calendar.DAY_OF_MONTH, 1)
            }
            SwipeDirection.SWIPE_VERTICAL -> {
                cal.time = currentDate
            }
        }
        return cal.time
    }
}