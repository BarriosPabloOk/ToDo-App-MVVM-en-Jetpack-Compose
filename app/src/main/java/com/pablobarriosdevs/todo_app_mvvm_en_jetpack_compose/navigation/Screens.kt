package com.pablobarriosdevs.easytask.common.navigation

sealed class Screen(val route : String){
    object TaskScreen : Screen("task_screen")
    object NewTaskScreen : Screen("new_task_screen")
    object SearchScreen : Screen("search_screen")
}
