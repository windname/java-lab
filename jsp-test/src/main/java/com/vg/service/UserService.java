package com.vg.service;


import java.util.Arrays;
import java.util.List;

public class UserService {
    public List<User> getUsers() {
        return Arrays.asList(
                new User(1, "Alice", "alice@example.com", true),
                new User(2, "Bob", "bob@example.com", false),
                new User(3, "Charlie", "charlie@example.com", true)
        );
    }

    public static class User {
        private int id;
        private String name;
        private String email;
        private boolean active;

        public User(int id, String name, String email, boolean active) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.active = active;
        }

        // Getters and setters
        public int getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public boolean isActive() { return active; }
    }
}