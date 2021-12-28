package com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pablobarriosdevs.todo_app_mvvm_en_jetpack_compose.feature_task.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskDao {
    @Query("SELECT * FROM task WHERE targetDate = :targetDate")
    fun getTasksByDate(targetDate:Long): Flow<List<Task>>

    @Query("UPDATE task SET isCompleted = :completed WHERE id = :taskId")
    suspend fun updateTaskCompleted(taskId : Int, completed: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task WHERE title LIKE '%' || :query || '%'")
    suspend fun searchTasks(query: String): Flow<List<Task>>

}