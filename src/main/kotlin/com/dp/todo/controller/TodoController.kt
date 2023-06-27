package com.dp.todo.controller

import com.dp.todo.dto.TodoCreationRequest
import com.dp.todo.dto.TodoResponse
import com.dp.todo.service.TodoService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {

    @PostMapping
    fun createNewTodo(@RequestBody todoCreationRequest: TodoCreationRequest): TodoResponse {
        return todoService.createNewTodo(todoCreationRequest)
    }

    @PutMapping("/{todoId}")
    fun updateTodoById(@PathVariable todoId: Long, @RequestBody todoCreationRequest: TodoCreationRequest): TodoResponse {
        return todoService.updateTodoById(todoId, todoCreationRequest)
    }

    @GetMapping
    fun findAllTodos(): List<TodoResponse> {
        return todoService.findAllTodos()
    }

    @GetMapping("/{todoId}")
    fun findTodoById(@PathVariable todoId: Long): TodoResponse {
        return todoService.findTodoById(todoId)
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodoById(@PathVariable todoId: Long): Map<String, String> {
        return todoService.deleteTodoById(todoId);
    }
}