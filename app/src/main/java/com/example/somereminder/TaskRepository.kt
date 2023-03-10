package com.example.somereminder

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {
    var readAllData:LiveData<List<Task>> = taskDao.readAllData()

    suspend fun addTask(task:Task){
        taskDao.addTask(task)
    }

}