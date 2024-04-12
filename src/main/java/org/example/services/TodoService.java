package org.example.services;

import org.example.models.Todo;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TodoService {
    private final String url;

    public TodoService() {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + "/todos";
    }

    public List<Todo> getAll() {
        return get(url)
                .getBody()
                .jsonPath()
                .getList(".", Todo.class);
    }

    public Todo create(Todo todo) {
        return given()
                .contentType("application/json")
                .body(todo)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", Todo.class);
    }

}
