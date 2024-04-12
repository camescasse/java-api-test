package org.example.services;

import org.example.models.User;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class UserService {
    private final String url;

    public UserService() {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + "/users";
    }

    public List<User> getAll() {
        return get(url)
                .getBody()
                .jsonPath()
                .getList(".", User.class);
    }

    public User create(User user) {
        return given()
                .contentType("application/json")
                .body(user)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", User.class);
    }

}
