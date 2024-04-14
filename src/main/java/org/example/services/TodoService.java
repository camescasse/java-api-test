package org.example.services;

import org.example.models.Todo;

import java.util.List;

public class TodoService {
    private final String url;
    private final APIClient<Todo> client;

    public TodoService() {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + "/todos";
        client = new APIClient<>();
    }

    public List<Todo> getAll() {
        return client.getCall(url, Todo.class);
    }

    public Todo create(Todo todo) {
        return client.postCall(todo, url, Todo.class);
    }

}
