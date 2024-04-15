package org.example.services;

import org.example.models.Todo;

import java.util.List;

public class TodoService {
    private final APIClient<Todo> client;

    public TodoService() {
        client = new APIClient<>("/todos", Todo.class);
    }

    public Todo create(Todo todo) {
        return client.post(todo);
    }

    public List<Todo> getAll() {
        return client.getAll();
    }

    public Todo getById(int id) {
        return client.getById(id);
    }

    public Todo override(Todo todo, int id) {
        return client.put(todo, id);
    }

    public Todo update(Todo todo, int id) {
        return client.patch(todo, id);
    }

    public int delete(int id) {
        return client.delete(id);
    }

}
