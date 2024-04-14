package org.example.services;

import org.example.models.User;

import java.util.List;

public class UserService {
    private final APIClient<User> client;

    public UserService() {
        client = new APIClient<>("/users", User.class);
    }

    public List<User> getAll() {
        return client.getCall();
    }

    public User create(User user) {
        return client.postCall(user);
    }

}
