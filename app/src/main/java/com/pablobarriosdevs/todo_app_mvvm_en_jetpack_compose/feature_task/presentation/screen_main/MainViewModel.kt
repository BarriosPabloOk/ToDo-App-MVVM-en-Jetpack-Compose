package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.presentation.screen_main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.use_cases.wrapper.Wrapper
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.util.SwipeDirection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val usesCases: Wrapper
) : ViewModel() {

    private val baseCalendar = Calendar.getInstance()

    private val _showDate = mutableStateOf<Date>(Date())
    val showDate: State<Date> = _showDate

    private val _listOfTask = mutableStateOf<List<Task>>(emptyList())
    val listOfTask: State<List<Task>> = _listOfTask

    private val _listToDelete = mutableStateOf<List<Int>>(emptyList())
    val listToDelete: State<List<Int>> = _listToDelete

    private var recentlyDeletedTasks: Task? = null

    private var getTasksJob: Job? = null

    init {
        _showDate.value = usesCases.setDateUseCase(baseCalendar, SwipeDirection.SWIPE_VERTICAL)
        getTasksByDate(_showDate.value.time)
    }

    fun onEvent(event: MainScreenEvent) {
        when(event){
            is MainScreenEvent.Delete -> {
                viewModelScope.launch {
                    usesCases.deleteUseCase(event.tasks)
                    recentlyDeletedTasks = event.tasks
                }
            }
            is MainScreenEvent.Swipe -> {
                when(event.direction){
                    SwipeDirection.SWIPE_LEFT -> {
                        _showDate.value =
                            usesCases.setDateUseCase(baseCalendar, SwipeDirection.SWIPE_LEFT)
                    }
                    SwipeDirection.SWIPE_RIGHT -> {
                        _showDate.value =
                            usesCases.setDateUseCase(baseCalendar, SwipeDirection.SWIPE_RIGHT)
                    }
                    SwipeDirection.SWIPE_VERTICAL -> {
                        _showDate.value =
                            usesCases.setDateUseCase(baseCalendar, SwipeDirection.SWIPE_VERTICAL)
                    }
                }
            }
            is MainScreenEvent.Restore -> {
                viewModelScope.launch {
                    usesCases.insertTaskUseCase(recentlyDeletedTasks ?: return@launch)
                    recentlyDeletedTasks = null
                }
            }
            is MainScreenEvent.CheckCompleted -> {
                viewModelScope.launch {
                    event.task.id?.let {
                        usesCases.updateTaskUseCase(it, !event.task.isCompleted)
                    }
                }

            }
        }
    }
    private fun getTasksByDate(timeInMillis : Long){
        getTasksJob?.cancel()
        getTasksJob = usesCases.getTaskUseCase(timeInMillis).onEach {
            _listOfTask.value = it
        }.launchIn(viewModelScope)
    }


}

















