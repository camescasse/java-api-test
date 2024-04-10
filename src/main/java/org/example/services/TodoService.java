package org.example.services;

import org.example.models.Todo;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TodoService {
    private final String endpoint;
    private final String host;

    public TodoService() {
        this.endpoint = "/todos";
        var reader = new PropertiesReader();
        this.host = reader.getProperty("HOST_URL");
    }

    public List<Todo> getAll() {
        return get(host + endpoint)
                .getBody()
                .jsonPath()
                .getList(".", Todo.class);
    }

    public Todo create(Todo todo) {
        return given()
                .contentType("application/json")
                .body(todo)
                .post(host + endpoint)
                .getBody()
                .jsonPath()
                .getObject(".", Todo.class);
    }
}
