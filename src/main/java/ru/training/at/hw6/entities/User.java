package ru.training.at.hw6.entities;

import ru.training.at.hw6.utils.ConfigReader;

public class User {

    public static final User ROMAN = new User(ConfigReader.getProperty("name"),
            ConfigReader.getProperty("password"),
            ConfigReader.getProperty("fullName"));

    private String name;
    private String password;
    private String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
