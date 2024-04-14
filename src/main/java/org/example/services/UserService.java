package org.example.services;

import org.example.models.User;

import java.util.List;

public class UserService {
    private final String url;
    private final APIClient<User> client;

    public UserService() {
        var reader = new PropertiesReader();
        var host = reader.getProperty("HOST");
        url = host + "/users";
        client = new APIClient<>();
    }

    public List<User> getAll() {
        return client.getCall(url, User.class);
    }

    public User create(User user) {
        return client.postCall(user, url, User.class);
    }

}
