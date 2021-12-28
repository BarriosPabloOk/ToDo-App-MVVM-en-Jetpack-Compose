package com.pablobarriosdevs.easytask.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pablobarriosdevs.easytask.presentation.new_task_screen.NewTaskScreen
import com.pablobarriosdevs.easytask.presentation.tasks_screen.TaskScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.TaskScreen.route){
        composable(
            route = Screen.TaskScreen.route,
        ){
            TaskScreen(navController = navController)
        }
        composable(
            route = Screen.NewTaskScreen.route + "?taskId={taskId}",
            arguments = listOf(
                navArgument(name = "taskId"){
                    type = NavType.IntType
                    defaultValue = -1
                })
        ){
            val taskId = it.arguments?.getInt("taskId") ?: -1
            NewTaskScreen(
                navController = navController,
                taskId = taskId
            )

        }

    }

}