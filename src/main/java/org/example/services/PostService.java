package org.example.services;

import org.example.models.Post;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PostService {
    private final String url;

    public PostService() {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + "/posts";
    }

    public List<Post> getAll() {
        return get(url)
                .getBody()
                .jsonPath()
                .getList(".", Post.class);
    }

    public Post create(Post post) {
        return given()
                .contentType("application/json")
                .body(post)
                .post(url)
                .getBody()
                .jsonPath()
                .getObject(".", Post.class);
    }

}
