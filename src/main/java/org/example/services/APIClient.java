package org.example.services;

import io.qameta.allure.restassured.AllureRestAssured;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APIClient<T> {
    private final String url;
    private final Class<T> type;
    private final AllureRestAssured allure;

    public APIClient(String endpoint, Class<T> type) {
        var hostProperty = PropertiesReader.getInstance().getProperty("HOST");
        String host;
        if (hostProperty == null || hostProperty.isEmpty()) host = "https://jsonplaceholder.typicode.com";
        else host = hostProperty;
        this.allure = new AllureRestAssured()
                .setRequestTemplate("http-request.ftl")
                .setResponseTemplate("http-response.ftl");
        this.url = host + endpoint;
        this.type = type;
    }

    public T post(T body) {
        return given()
                .filter(allure)
                .contentType("application/json")
                .body(body)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public List<T> getAll() {
        return given()
                .filter(allure)
                .get(url)
                .getBody()
                .jsonPath()
                .getList(".", type);
    }

    public T getById(int id) {
        return given()
                .filter(allure)
                .get(url + "/" + id)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public T put(T body, int id) {
        return given()
                .filter(allure)
                .contentType("application/json")
                .body(body)
                .put(url + "/" + id)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public T patch(T body, int id) {
        return given()
                .filter(allure)
                .contentType("application/json")
                .body(body)
                .patch(url + "/" + id)
                .getBody()
                .jsonPath()
                .getObject(".", type);
    }

    public int delete(int id) {
        return given()
                .filter(allure)
                .delete(url + "/" + id)
                .getStatusCode();
    }

}
