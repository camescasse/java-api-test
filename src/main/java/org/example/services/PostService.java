package org.example.services;

import org.example.models.Post;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PostService {
    private PropertiesReader reader;
    private String endpoint;
    private String host;

    public PostService() {
        this.reader = new PropertiesReader();
        this.endpoint = "/posts";
        this.host = reader.getProperty("HOST_URL");
    }

    public List<Post> getAll() {
        return get(host + endpoint)
                .getBody()
                .jsonPath()
                .getList(".", Post.class);
    }

    public Post create(Post post) {
        return given()
                .contentType("application/json")
                .body(post)
                .post(host + endpoint)
                .getBody()
                .jsonPath()
                .getObject(".", Post.class);
    }
}
