package com.task.beeline.controller

import com.task.beeline.model.Task
import com.task.beeline.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class TaskController(private val taskService: TaskService) { // Внедряем наш сервис в качестве зависимости

    @GetMapping("/tasks")
    fun findAll(model: Model): String {
        val tasks: List<Task> = taskService.findAll() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа
        model.addAttribute("tasks", tasks)
        return "task-list"
    }

    @GetMapping("/task-create")
    fun createTaskForm(task: Task): String {
        return "task-create"
    }

    @PostMapping("task-create")
    @ResponseStatus(HttpStatus.CREATED) // Указываем специфический HttpStatus при успешном ответе
    fun createTask(task: Task): String {
        taskService.saveUser(task)
        return "redirect:/tasks"
    }

    @GetMapping("task-delete/{id}")
    fun deleteUser(@PathVariable("id") id: Long): String {
        taskService.deleteById(id)
        return "redirect:/tasks"
    }

    @GetMapping("/task-update/{id}")
    fun updateUserForm(@PathVariable("id") id: Long, model: Model): String {
        val task: Task = taskService.findById(id)
        model.addAttribute("task", task)
        return "task-update"
    }

    @PostMapping("/task-update")
    fun updateUser(task: Task): String {
        taskService.saveUser(task)
        return "redirect:/tasks"
    }
}