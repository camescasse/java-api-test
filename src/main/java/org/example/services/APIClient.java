package org.example.services;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class APIClient<T> {
    private final String url;
    private final Class<T> type;

    public APIClient(String endpoint, Class<T> type) {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        this.url = host + endpoint;
        this.type = type;

    }

    public T post(T body) {
        return given()
                .contentType("application/json")
                .body(body)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public List<T> getAll() {
        return get(url)
                .getBody()
                .jsonPath()
                .getList(".", type);
    }

    public T getById(int id) {
        return get(url + "/" + id)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public T put(T body, int id) {
        return given()
                .contentType("application/json")
                .body(body)
                .put(url + "/" + id)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public T patch(T body, int id) {
        return given()
                .contentType("application/json")
                .body(body)
                .patch(url + "/" + id)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public int delete(int id) {
        return given()
                .delete(url + "/" + id).getStatusCode();
    }

}
