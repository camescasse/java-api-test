package org.example.services;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class APIClient<T> {
    private final String url;
    private final Class<T> type;

    public APIClient(String endpoint, Class<T> tClass) {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + endpoint;
        type = tClass;

    }

    public List<T> getCall() {
        return get(url)
                .getBody()
                .jsonPath()
                .getList(".", type);
    }

    public T postCall(T body) {
        return given()
                .contentType("application/json")
                .body(body)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

}