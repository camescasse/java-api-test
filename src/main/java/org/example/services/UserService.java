package org.example.services;

import org.example.models.User;

import java.util.List;

public class UserService {
    private final APIClient<User> client;

    public UserService() {
        client = new APIClient<>("/users", User.class);
    }

    public List<User> getAll() {
        return client.getAll();
    }

    public User getById(int id) {
        return client.getById(id);
    }

    public User create(User user) {
        return client.post(user);
    }

}
