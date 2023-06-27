package com.dp.todo.service

import com.dp.todo.dto.TodoCreationRequest
import com.dp.todo.dto.TodoResponse

interface TodoService {

    fun createNewTodo(todoCreationRequest: TodoCreationRequest): TodoResponse

    fun updateTodoById(todoId: Long, todoCreationRequest: TodoCreationRequest): TodoResponse

    fun findAllTodos(): List<TodoResponse>

    fun findTodoById(todoId: Long): TodoResponse

    fun deleteTodoById(todoId: Long): Map<String, String>
}