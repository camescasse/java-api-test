package org.example.services;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class APIClient<T> {

    public List<T> getCall(String url, Class<T> tClass) {
        return get(url)
                .getBody()
                .jsonPath()
                .getList(".", tClass);
    }

    public T postCall(T body, String url, Class<T> tClass) {
        return given()
                .contentType("application/json")
                .body(body)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", tClass);
    }

}
