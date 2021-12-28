package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.presentation.screen_main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pablobarriosdevs.easytask.presentation.tasks_screen.components.DateDisplay
import com.pablobarriosdevs.easytask.presentation.tasks_screen.components.TaskComponent
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.R

@Composable
fun TaskScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
) {

    val scaffoldState = rememberScaffoldState()
    val listOfTask = viewModel.listOfTask
    Scaffold(
        scaffoldState = scaffoldState,

        floatingActionButton = {
            FloatingActionButton(onClick = {}) {

            }
        },
        floatingActionButtonPosition = FabPosition.Center,

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {

                DateDisplay(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    currentDate = viewModel.showDate.value
                )
                Text(
                    text = stringResource(id = R.string.swipe_to),
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    fontWeight = FontWeight.Thin
                )
                Spacer(modifier = Modifier.height(30.dp))

                LazyColumn(){
                    items(listOfTask.value){ task->
                        TaskComponent(
                            title = task.title,
                            isChecked = task.isCompleted
                        ) {
                        }
                    }
                }
            }


        }


    }
}