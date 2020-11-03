package com.task.beeline.service

import com.task.beeline.model.Task
import com.task.beeline.repository.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service // Позволяем IoC контейнеру внедрять класс
class TaskService(private val taskRepository: TaskRepository) { // Внедряем репозиторий в качестве зависимости

    fun getTasks(): List<Task> {
        return taskRepository.findAll()
    }

    fun addTask(task: Task): ResponseEntity<Task> =
            ResponseEntity.ok(taskRepository.save(task))

    fun getTaskById(taskId: Long): ResponseEntity<Task> =
            taskRepository.findById(taskId).map { task -> ResponseEntity.ok(task) }.orElse(ResponseEntity.notFound().build())

    fun putTask(taskId: Long, newTask: Task): ResponseEntity<Task> =
            taskRepository.findById(taskId).map { currentTask ->
                val updatedTask: Task =
                        currentTask
                                .copy(
                                        project = newTask.project,
                                        title = newTask.title,
                                        description = newTask.description,
                                        assign = newTask.assign
                                )
                ResponseEntity.ok().body(taskRepository.save(updatedTask))
            }.orElse(ResponseEntity.notFound().build())

    fun deleteTask(taskId: Long): ResponseEntity<Void> =
            taskRepository.findById(taskId).map { task ->
                taskRepository.delete(task)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())
}