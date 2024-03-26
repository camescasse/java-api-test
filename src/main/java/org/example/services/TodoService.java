package org.example.services;

import org.example.models.Todo;
import java.util.List;
import static io.restassured.RestAssured.*;

public class TodoService {
    private PropertiesReader reader;
    private String endpoint;
    private String host;

    public TodoService() {
        this.reader = new PropertiesReader();
        this.endpoint = "/todos";
        this.host = reader.getProperty("HOST_URL");
    }

    public List<Todo> getAll(){
        return get(host + endpoint)
                .getBody()
                .jsonPath()
                .getList(".", Todo.class);
    }

    public Todo create(Todo todo){
        return given()
                .contentType("application/json")
                .body(todo)
                .post(host + endpoint)
                .getBody()
                .jsonPath()
                .getObject(".", Todo.class);
    }
}
