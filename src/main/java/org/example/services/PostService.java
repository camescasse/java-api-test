package org.example.services;

import org.example.models.Post;

import java.util.List;

public class PostService {
    private final String url;
    private final APIClient<Post> client;

    public PostService() {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + "/posts";
        client = new APIClient<>();
    }

    public List<Post> getAll() {
        return client.getCall(url, Post.class);
    }

    public Post create(Post post) {
        return client.postCall(post, url, Post.class);
    }

}
