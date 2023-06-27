package com.dp.todo.service.impl

import com.dp.todo.dto.TodoCreationRequest
import com.dp.todo.dto.TodoResponse
import com.dp.todo.entity.Todo
import com.dp.todo.repository.TodoRepository
import com.dp.todo.service.TodoService
import org.modelmapper.ModelMapper
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(private val todoRepository: TodoRepository,
                      private val modelMapper: ModelMapper) : TodoService {

    override fun createNewTodo(todoCreationRequest: TodoCreationRequest): TodoResponse {
        return modelMapper.map(todoRepository.save(
                modelMapper.map(todoCreationRequest, Todo::class.java)), TodoResponse::class.java);
    }

    override fun updateTodoById(todoId: Long, todoCreationRequest: TodoCreationRequest): TodoResponse {
        val oldTodo = findById(todoId)
        modelMapper.map(todoCreationRequest, oldTodo)
        return modelMapper.map(todoRepository.save(oldTodo), TodoResponse::class.java)
    }

    override fun findAllTodos(): List<TodoResponse> {
        return todoRepository.findAll().stream().map { todo -> modelMapper.map(todo, TodoResponse::class.java) }.toList();
    }

    override fun findTodoById(todoId: Long): TodoResponse {
        return modelMapper.map(findById(todoId), TodoResponse::class.java)

    }

    override fun deleteTodoById(todoId: Long): Map<String, String> {
        todoRepository.deleteById(todoId)
        return mapOf("message" to "TODO Deleted Successfully.")
    }

    private final fun findById(todoId: Long): Todo {
        return todoRepository.findById(todoId)
                .orElseThrow {
                    throw NotFoundException()
                }
    }
}