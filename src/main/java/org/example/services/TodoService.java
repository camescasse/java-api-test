package org.example.services;

import org.example.models.Todo;

import java.util.List;

public class TodoService {
    private final APIClient<Todo> client;

    public TodoService() {
        client = new APIClient<>("/todos", Todo.class);
    }

    public List<Todo> getAll() {
        return client.getAll();
    }

    public Todo create(Todo todo) {
        return client.post(todo);
    }

}
