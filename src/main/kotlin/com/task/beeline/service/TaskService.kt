package com.task.beeline.service

import com.task.beeline.model.Task
import com.task.beeline.repository.TaskRepository
import org.springframework.stereotype.Service

@Service // Позволяем IoC контейнеру внедрять класс
class TaskService(private val taskRepository: TaskRepository) { // Внедряем репозиторий в качестве зависимости

    fun findById(id: Long): Task {
        return taskRepository.getOne(id)
    }

    fun findAll(): List<Task> {
        return taskRepository.findAll()
    }

    fun saveUser(task: Task): Task {
        return taskRepository.save(task)
    }

    fun deleteById(id: Long) {
        taskRepository.deleteById(id)
    }
}