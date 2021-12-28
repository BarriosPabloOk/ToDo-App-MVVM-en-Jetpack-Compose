package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.presentation.ui.theme.ToDoAppMVVMenJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppMVVMenJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

