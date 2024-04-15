package org.example.services;

import org.example.models.Post;

import java.util.List;

public class PostService {
    private final APIClient<Post> client;

    public PostService() {
        client = new APIClient<>("/posts", Post.class);
    }

    public Post create(Post post) {
        return client.post(post);
    }

    public List<Post> getAll() {
        return client.getAll();
    }

    public Post getById(int id) {
        return client.getById(id);
    }

    public Post override(Post post, int id) {
        return client.put(post, id);
    }

    public Post update(Post post, int id) {
        return client.patch(post, id);
    }

    public int delete(int id) {
        return client.delete(id);
    }

}
