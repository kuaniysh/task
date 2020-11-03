package com.task.beeline.controller

import com.task.beeline.model.Task
import com.task.beeline.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/tasks")
class TaskController(private val taskService: TaskService) { // Внедряем наш сервис в качестве зависимости
    @GetMapping
    fun getTasks(model: Model): String {
        val tasks: List<Task> = taskService.getTasks() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа
        model.addAttribute("tasks", tasks)
        return "task-list"
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Указываем специфический HttpStatus при успешном ответе
    fun addTask(@RequestBody task: Task): String {
        taskService.addTask(task)
        return "redirect:/tasks"
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable(value = "id") taskId: Long): ResponseEntity<Task> =
            taskService.getTaskById(taskId)

    @PutMapping("/{id}")
    fun updateTaskById(
            @PathVariable(value = "id") taskId: Long,
            @RequestBody newTask: Task): String {
        taskService.putTask(taskId, newTask)
        return "redirect:/tasks"
    }

    @GetMapping("task-delete/{id}")
    fun deleteTask(@PathVariable("id") taskId: Long): String {
        taskService.deleteTask(taskId)
        return "redirect:/tasks"
    }
}