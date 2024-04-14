package org.example.services;

import org.example.models.Post;

import java.util.List;

public class PostService {
    private final APIClient<Post> client;

    public PostService() {
        client = new APIClient<>("/posts", Post.class);
    }

    public List<Post> getAll() {
        return client.getCall();
    }

    public Post create(Post post) {
        return client.postCall(post);
    }

}
