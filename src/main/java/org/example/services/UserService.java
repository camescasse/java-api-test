package org.example.services;

import org.example.models.User;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class UserService {
    private final String endpoint;
    private final String host;

    public UserService() {
        this.endpoint = "/users";
        var reader = new PropertiesReader();
        this.host = reader.getProperty("HOST_URL");
    }

    public List<User> getAll() {
        return get(host + endpoint)
                .getBody()
                .jsonPath()
                .getList(".", User.class);
    }

    public User create(User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .post(host + endpoint)
                .getBody()
                .jsonPath()
                .getObject(".", User.class);
    }
}
